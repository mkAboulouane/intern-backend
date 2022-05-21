package com.fst.sir.service.gerant.service.impl;

import com.fst.sir.bean.ProduitBio;
import com.fst.sir.dao.ProduitBioDao;
import com.fst.sir.service.gerant.service.facade.ProduitBioGerantService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class ProduitBioGerantServiceImpl implements ProduitBioGerantService {

    @Autowired
    private ProduitBioDao produitBioDao;

    @Override
    public ProduitBio findByNom(String nom) {
        return produitBioDao.findByNom(nom);
    }

    @Override
    public List<ProduitBio> findAll() {
        return produitBioDao.findAll();
    }

    @Override
    public int deleteByNom(String nom) {
        return 0;
    }

    @Override
    public ProduitBio save(ProduitBio produitBio) {
        ProduitBio produitBio1 = findByNom(produitBio.getNom());
        if (produitBio1 == null) {
            produitBio.setAddedAt(new Date());
            return produitBioDao.save(produitBio);
        } else return null;
    }

    @Override
    public ProduitBio update(ProduitBio produitBio) {
        ProduitBio produitBio1 = findByNom(produitBio.getNom());
        if (produitBio1 != null) {
            produitBio.setUpdatedAt(new Date());
            produitBio.setAddedAt(produitBio1.getAddedAt());
            produitBio.setId(produitBio1.getId());
            return produitBioDao.save(produitBio);
        } else return null;
    }

}
