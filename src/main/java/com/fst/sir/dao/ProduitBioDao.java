package com.fst.sir.dao;

import com.fst.sir.bean.ProduitBio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitBioDao extends JpaRepository<ProduitBio, Long> {

    @Query("SELECT item FROM ProduitBio item ORDER BY item.id DESC ")
    List<ProduitBio> findAll();

    ProduitBio findByNom(String nom);

    void deleteById(Long id);

    void deleteByImagePrincipalId(Long id);

}
