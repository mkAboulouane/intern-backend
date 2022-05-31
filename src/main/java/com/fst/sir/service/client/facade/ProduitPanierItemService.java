package com.fst.sir.service.client.facade;

import com.fst.sir.bean.Panier;
import com.fst.sir.bean.ProduitPanierItem;

import java.util.List;

public interface ProduitPanierItemService {

    Double prixTotal(List<ProduitPanierItem> produitPanierItems);

    ProduitPanierItem save(ProduitPanierItem produitPanierItem);

    ProduitPanierItem save(ProduitPanierItem produitPanierItem, Panier panier);

    List<ProduitPanierItem> save(List<ProduitPanierItem> produitPanierItems, Panier panier);

    List<ProduitPanierItem> save(List<ProduitPanierItem> produitPanierItem);

    ProduitPanierItem update(ProduitPanierItem produitPanierItem);

    int delete(ProduitPanierItem produitPanierItem);

}
