package com.fst.sir.dao;

import com.fst.sir.bean.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Long> {

    Commande findByReference(String reference);

    void deleteByReference(String reference);

    List<Commande> findByUserId(Long id);


}
