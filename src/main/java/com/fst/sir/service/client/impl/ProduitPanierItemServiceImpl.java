package com.fst.sir.service.client.impl;

import com.fst.sir.bean.Panier;
import com.fst.sir.bean.ProduitBio;
import com.fst.sir.bean.ProduitPanierItem;
import com.fst.sir.dao.ProduitPanierItemDao;
import com.fst.sir.service.admin.facade.PanierAdminService;
import com.fst.sir.service.admin.facade.ProduitBioAdminService;
import com.fst.sir.service.client.facade.ProduitPanierItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduitPanierItemServiceImpl implements ProduitPanierItemService {

    @Autowired
    private ProduitPanierItemDao produitPanierItemDao;
    @Autowired
    private ProduitBioAdminService produitBioAdminService;
    @Autowired
    private PanierAdminService panierAdminService;

    @Override
    public ProduitPanierItem save(ProduitPanierItem produitPanierItem) {
        ProduitBio produitBio = produitBioAdminService.findByNom(produitPanierItem.getProduitBio().getNom());
        Panier panier = panierAdminService.findByReference(produitPanierItem.getPanier().getReference());
        produitPanierItem.setPrix(produitPanierItem.getPrix() * produitPanierItem.getQuantite());
        produitPanierItem.setProduitBio(produitBio);
        produitPanierItem.setPanier(panier);
        return produitPanierItemDao.save(produitPanierItem);
    }

    @Override
    public ProduitPanierItem update(ProduitPanierItem produitPanierItem) {
        ProduitPanierItem produitPanierItem1 = produitPanierItemDao.findById(produitPanierItem.getId()).get();
        produitPanierItem.setId(produitPanierItem1.getId());
        return save(produitPanierItem);
    }

    @Override
    public int delete(ProduitPanierItem produitPanierItem) {
        return 0;
    }
}
