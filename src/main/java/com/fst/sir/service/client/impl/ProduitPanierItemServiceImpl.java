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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProduitPanierItemServiceImpl implements ProduitPanierItemService {

    @Autowired
    private ProduitPanierItemDao produitPanierItemDao;
    @Autowired
    private ProduitBioAdminService produitBioAdminService;
    @Autowired
    private PanierAdminService panierAdminService;

    @Override
    public Double prixTotal(List<ProduitPanierItem> produitPanierItems) {
        Double result = 0D;
        for (ProduitPanierItem produitPanierItem : produitPanierItems) {
            ProduitBio produitBio = produitBioAdminService.findByNom(produitPanierItem.getProduitBio().getNom());
            result +=  produitBio.getPrix()*produitPanierItem.getQuantite();
        }
        return result;
    }

    @Override
    public List<ProduitPanierItem> save(List<ProduitPanierItem> produitPanierItems, Panier panier) {
        List<ProduitPanierItem> result = new ArrayList<>();
        for (ProduitPanierItem produitPanierItem : produitPanierItems) {
            result.add(save(produitPanierItem,panier));
        }
        return result;
    }

    @Override
    public List<ProduitPanierItem> save(List<ProduitPanierItem> produitPanierItem) {
        List<ProduitPanierItem> produitPanierItems = new ArrayList<>();
        for (ProduitPanierItem panierItem : produitPanierItem) {
            produitPanierItems.add(save(panierItem));
        }
        return produitPanierItems;
    }

    @Override
    public ProduitPanierItem save(ProduitPanierItem produitPanierItem, Panier panier) {
         produitPanierItem.setPanier(panier);
         return save(produitPanierItem);
    }



    @Override
    public ProduitPanierItem save(ProduitPanierItem produitPanierItem) {
        ProduitBio produitBio = produitBioAdminService.findByNom(produitPanierItem.getProduitBio().getNom());
        produitPanierItem.setPrix(BigDecimal.valueOf(produitBio.getPrix()).multiply(BigDecimal.valueOf(produitPanierItem.getQuantite())));
        produitPanierItem.setProduitBio(produitBio);
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
