package com.fst.sir.dao;

import com.fst.sir.bean.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FormationDao extends JpaRepository<Formation,Long> {

    @Query("SELECT item FROM Formation item ORDER BY item.id DESC ")
    List<Formation> findAll();

    Formation findByNom(String nom);

    int deleteByNom(String nom);

    void deleteById(Long id);
    List<Formation> findByEncadrantProf(String encadrant);



}
