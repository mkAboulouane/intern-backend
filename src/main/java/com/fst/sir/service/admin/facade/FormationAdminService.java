package com.fst.sir.service.admin.facade;

import com.fst.sir.bean.Formation;

import java.util.List;

public interface FormationAdminService {
    Formation findByNom(String nom);

    int deleteByNom(String nom);

    List<Formation> findByEncadrantProf(String encadrant);

    List<Formation> findAll();

    Formation save(Formation formation);

    Formation update(Formation formation);


}
