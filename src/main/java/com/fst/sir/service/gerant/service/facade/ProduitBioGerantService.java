package com.fst.sir.service.gerant.service.facade;

import com.fst.sir.bean.ProduitBio;

import java.util.List;

public interface ProduitBioGerantService {

    List<ProduitBio> findAll();

    ProduitBio findByNom(String nom);

    int deleteByNom(String nom);

    ProduitBio save(ProduitBio produitBio);

    ProduitBio update(ProduitBio produitBio);

}
