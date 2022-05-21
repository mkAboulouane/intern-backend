package com.fst.sir.dao;

import com.fst.sir.bean.Congres;
import com.fst.sir.bean.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CongresDao extends JpaRepository<Congres,Long> {
    Congres findByNom(String nom);

    @Query("SELECT item FROM Congres item ORDER BY item.id DESC")
    List<Congres> findAll();

    int deleteByNom(String nom);

    List<Congres> findByEncadrantProf(String encadrant);
}
