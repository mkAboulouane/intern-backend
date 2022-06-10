package com.fst.sir.service.admin.impl;

import com.fst.sir.bean.Paiment;
import com.fst.sir.bean.Panier;
import com.fst.sir.dao.PaimentDao;
import com.fst.sir.enums.TypePaiment;
import com.fst.sir.service.admin.facade.PaimentAdminService;
import com.fst.sir.service.admin.facade.PanierAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PaimentAdminServiceImpl implements PaimentAdminService {
    @Autowired
    private PaimentDao paimentDao;
    @Autowired
    private PanierAdminService panierAdminService;

    @Override
    public List<Paiment> findAll() {
        return paimentDao.findAll();
    }

    @Override
    public List<Paiment> findByTypePaiment(TypePaiment typePaiment) {
        return paimentDao.findByTypePaiment(typePaiment);
    }

    @Override
    public List<Paiment> findByPanierUserUsername(String username) {
        return paimentDao.findByPanierUserUsername(username);
    }

    @Override
    public Paiment findByReference(String reference) {
        return paimentDao.findByReference(reference);
    }

    @Override
    public int deleteByReference(String reference) {
        return 0;
    }

    @Override
    public Paiment save(Paiment paiment) {
        Panier panier = panierAdminService.findByReference(paiment.getReference());
        if (BigDecimal.valueOf(paiment.getPrix()).equals(panier.getPrixTotal())) {
            paiment.setPayedAt(new Date());
            paiment.setPrix(panier.getPrixTotal().doubleValue());
            return paimentDao.save(paiment);
        } else return null;
    }

    @Override
    public Paiment update(Paiment paiment) {
        Paiment paiment1 = findByReference(paiment.getReference());
        Panier panier = panierAdminService.findByReference(paiment.getReference());
        if (paiment1 != null && BigDecimal.valueOf(paiment.getPrix()).equals(panier.getPrixTotal())) {
            paiment.setId(paiment1.getId());
            paiment.setPayedAt(new Date());
            paiment.setPrix(panier.getPrixTotal().doubleValue());
            return paimentDao.save(paiment);
        } else return null;

    }
}
