package com.fst.sir.ws.rest.provided.facade.admin;

import com.fst.sir.bean.ProduitBio;

public class Produit {
    private ProduitBio produitBio;
    private Long id;

    public ProduitBio getProduitBio() {
        return produitBio;
    }

    public void setProduitBio(ProduitBio produitBio) {
        this.produitBio = produitBio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
