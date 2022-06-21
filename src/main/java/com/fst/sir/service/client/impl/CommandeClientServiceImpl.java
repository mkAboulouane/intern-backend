package com.fst.sir.service.client.impl;

import com.fst.sir.bean.Commande;
import com.fst.sir.bean.Formation;
import com.fst.sir.bean.ProduitBio;
import com.fst.sir.config.FileUtils;
import com.fst.sir.config.ReferenceUtil;
import com.fst.sir.dao.CommandeDao;
import com.fst.sir.security.bean.User;
import com.fst.sir.security.common.SecurityUtil;
import com.fst.sir.service.admin.facade.FormationAdminService;
import com.fst.sir.service.admin.facade.ProduitBioAdminService;
import com.fst.sir.service.client.facade.CommandeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class CommandeClientServiceImpl implements CommandeClientService {

    @Autowired
    private CommandeDao commandeDao;
    @Autowired
    private FormationAdminService formationAdminService;
    @Autowired
    private ProduitBioAdminService produitBioAdminService;

    @Override
    public List<Commande> findAll() {
        return commandeDao.findAll();
    }

    @Override
    public Commande findByReference(String reference) {
        return commandeDao.findByReference(reference);
    }

    @Override
    public void deleteByReference(String reference) {
            commandeDao.deleteByReference(reference);
    }

    @Override
    public List<Commande> findByUserId() {
        User user = SecurityUtil.getCurrentUser();
        List<Commande> byUserId = commandeDao.findByUserId(user.getId());
        byUserId.forEach(e->{
            if(e.getProduitBio()!=null)
            e.getProduitBio().getImagePrincipal().setPicByte(FileUtils.decompressBytes(e.getProduitBio().getImagePrincipal().getPicByte()));
        });
        return byUserId;
    }

    @Override
    public Commande save(Commande commande) {
        User user = SecurityUtil.getCurrentUser();
        commande.setUser(user);
        if (commande.getFormation() != null && commande.getFormation().getNom() != null ) {
            Formation formation = formationAdminService.findByNom(commande.getFormation().getNom());
            commande.setFormation(formation);
            commande.setTotal(BigDecimal.valueOf(formation.getPrix()));
            commande.setProduitBio(null);
        }else if(commande.getProduitBio() != null && commande.getProduitBio().getNom() != null){
            ProduitBio produitBio = produitBioAdminService.findByNom(commande.getProduitBio().getNom());
            commande.setProduitBio(produitBio);
            commande.setFormation(null);
            commande.setTotal(BigDecimal.valueOf(produitBio.getPrix()));
        }
        commande.setReference("EA-"+ReferenceUtil.generateReference().toString()+"-UC");
        commande.setPaye(false);
        commande.setAddedAt(new Date());
        return commandeDao.save(commande);
    }

    @Override
    public Commande update(Commande commande) {
        return null;
    }

    @Override
    public int delete(Long id) {
        if (id != null) {
            commandeDao.deleteById(id);
        }
         return 1;
    }
}
