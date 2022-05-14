package com.fst.sir.service.client.impl;

import com.fst.sir.bean.Formation;
import com.fst.sir.bean.Panier;
import com.fst.sir.dao.PanierDao;
import com.fst.sir.enums.EtatCommande;
import com.fst.sir.security.dao.UserDao;
import com.fst.sir.service.admin.facade.FormationAdminService;
import com.fst.sir.service.admin.facade.ProduitBioAdminService;
import com.fst.sir.service.client.facade.PanierClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanierClientServiceImpl implements PanierClientService {
    @Autowired
    private PanierDao panierDao;

    @Autowired
    private FormationAdminService formationAdminService;

    @Autowired
    private ProduitBioAdminService produitBioAdminService;

    @Override
    public Panier save(Panier panier) {
        Formation formation = formationAdminService.findByNom(panier.getFormation().getNom());


        return panierDao.save(panier);
    }

    @Override
    public Panier update(Panier panier) {
        return null;
    }

    @Override
    public List<Panier> findAll() {
        return panierDao.findAll();
    }

    @Override
    public List<Panier> findByEtatCommande(EtatCommande etatCommande) {
        return panierDao.findByEtatCommande(etatCommande);
    }

    @Override
    public List<Panier> findByUserUsername(String username) {
        return panierDao.findByUserUsername(username);
    }

    @Override
    public Panier findByReference(String reference) {
        return panierDao.findByReference(reference);
    }

    @Override
    public int deleteByReference(String reference) {
        return 0;
    }
}
