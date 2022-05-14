package com.fst.sir.service.admin.facade;

import com.fst.sir.bean.Formation;
import com.fst.sir.bean.ProduitBio;

import java.util.List;

public interface ProduitBioAdminService {

    List<ProduitBio> findAll();

    ProduitBio findByNom(String nom);

    int deleteByNom(String nom);

    ProduitBio save(ProduitBio produitBio);

    ProduitBio update(ProduitBio produitBio);



}
