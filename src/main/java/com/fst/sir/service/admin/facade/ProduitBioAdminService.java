package com.fst.sir.service.admin.facade;

import com.fst.sir.bean.ProduitBio;

import java.util.List;

public interface ProduitBioAdminService {

    List<ProduitBio> findAll();

    ProduitBio findByNom(String nom);

    ProduitBio findById(Long id);

    int deleteByNom(String nom);

    ProduitBio save(ProduitBio produitBio);




    int save(ProduitBio produitBio, long id);

    ProduitBio update(ProduitBio produitBio);


}
