package com.fst.sir.dao;

import com.fst.sir.bean.Panier;
import com.fst.sir.enums.EtatCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PanierDao extends JpaRepository<Panier, Long> {

    @Query("SELECT item FROM Panier item ORDER BY item.dateAjout ASC")
    List<Panier> findAll();


    List<Panier> findByEtatCommande(EtatCommande etatCommande);


    List<Panier> findByUserUsername(String username);


    Panier findByReference(String reference);

    int deleteByReference(String reference);

}
