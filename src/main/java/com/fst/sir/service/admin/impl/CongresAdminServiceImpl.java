package com.fst.sir.service.admin.impl;

import com.fst.sir.bean.Congres;
import com.fst.sir.dao.CongresDao;
import com.fst.sir.service.admin.facade.CongresAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CongresAdminServiceImpl implements CongresAdminService {

    @Autowired
    private CongresDao congresDao;

    @Override
    public Congres findByNom(String nom) {
        return congresDao.findByNom(nom);
    }

    @Override
    public int deleteByNom(String nom) {
        return 0;
    }

    @Override
    public List<Congres> findByEncadrantProf(String encadrant) {
        return congresDao.findByEncadrantProf(encadrant);
    }

    @Override
    public List<Congres> findAll() {
        return congresDao.findAll();
    }

    @Override
    public Congres save(Congres congres) {
        Congres entity = findByNom(congres.getNom());
        if (entity == null) {
            congres.setAddedAt(new Date());
            return congresDao.save(congres);
        }
        return null;
    }

    @Override
    public Congres update(Congres congres) {
        Congres entity = findByNom(congres.getNom());
        if (entity != null) {
            congres.setId(entity.getId());
            congres.setAddedAt(entity.getAddedAt());
            congres.setUpdatedAt(new Date());
            return congresDao.save(congres);
        } else return null;
    }
}
