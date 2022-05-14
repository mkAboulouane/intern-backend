package com.fst.sir.dao;

import com.fst.sir.bean.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FormationDao extends JpaRepository<Formation,Long> {

    Formation findByNom(String nom);

    int deleteByNom(String nom);

    List<Formation> findByEncadrantProf(String encadrant);

}
