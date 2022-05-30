package com.fst.sir.service.client.facade;

import com.fst.sir.bean.ProduitPanierItem;

import java.util.List;

public interface ProduitPanierItemService {

    ProduitPanierItem save(ProduitPanierItem produitPanierItem);

    List<ProduitPanierItem> save(List<ProduitPanierItem> produitPanierItem);

    ProduitPanierItem update(ProduitPanierItem produitPanierItem);

    int delete(ProduitPanierItem produitPanierItem);

}
