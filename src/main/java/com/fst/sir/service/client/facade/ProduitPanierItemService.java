package com.fst.sir.service.client.facade;

import com.fst.sir.bean.ProduitPanierItem;

public interface ProduitPanierItemService {

    ProduitPanierItem save(ProduitPanierItem produitPanierItem);

    ProduitPanierItem update(ProduitPanierItem produitPanierItem);

    int delete(ProduitPanierItem produitPanierItem);

}
