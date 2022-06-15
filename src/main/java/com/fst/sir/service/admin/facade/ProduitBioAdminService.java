package com.fst.sir.service.admin.facade;

import com.fst.sir.bean.ProduitBio;

import java.util.List;

public interface ProduitBioAdminService {

    List<ProduitBio> findAll();

    List<ProduitBio> voirAussi(Long existId);

    ProduitBio findByNom(String nom);

    ProduitBio findById(Long id);

    int deleteById(Long id);

    ProduitBio save(ProduitBio produitBio);




    int save(ProduitBio produitBio, long id);

    ProduitBio update(ProduitBio produitBio);


}
