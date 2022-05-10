package com.fst.sir.dao;

import com.fst.sir.bean.Reunion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReunionDao extends JpaRepository<Reunion, Long> {
    Reunion findByNom(String nom);
    List<Reunion> findByEncadrantProf(String encadrantProf);

    int deleteByNom(String nom);


}

