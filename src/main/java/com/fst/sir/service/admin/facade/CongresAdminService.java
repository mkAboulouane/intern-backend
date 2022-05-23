package com.fst.sir.service.admin.facade;

import com.fst.sir.bean.Congres;

import java.util.List;

public interface CongresAdminService {

    Congres findByNom(String nom);

    int deleteByNom(String nom);

    List<Congres> findByEncadrantProf(String encadrant);

    List<Congres> findAll();

    Congres save(Congres congres);

    Congres update(Congres congres);


}
