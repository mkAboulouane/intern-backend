package com.fst.sir.service.gerant.service.facade;

import com.fst.sir.bean.Formation;

import java.util.List;

public interface FormationGerantService {

    Formation findByNom(String nom);

    int deleteByNom(String nom);

    List<Formation> findByEncadrantProf(String encadrant);

    List<Formation> findAll();

    Formation save(Formation formation);

    Formation update(Formation formation);

}
