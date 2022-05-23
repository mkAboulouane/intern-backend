package com.fst.sir.service.client.impl;

import com.fst.sir.bean.Paiment;
import com.fst.sir.bean.Panier;
import com.fst.sir.dao.PaimentDao;
import com.fst.sir.enums.TypePaiment;
import com.fst.sir.service.client.facade.PaimentClientService;
import com.fst.sir.service.client.facade.PanierClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PaimentClientServiceImpl implements PaimentClientService {

    @Autowired
    private PaimentDao paimentDao;
    @Autowired
    private PanierClientService panierAdminService;

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
        if (paiment.getPrix() == panier.getPrixTotal()) {
            paiment.setPayedAt(new Date());
            paiment.setPrix(panier.getPrixTotal());
            return paimentDao.save(paiment);
        } else return null;
    }

    @Override
    public Paiment update(Paiment paiment) {
        Paiment paiment1 = findByReference(paiment.getReference());
        Panier panier = panierAdminService.findByReference(paiment.getReference());
        if (paiment1 != null && paiment.getPrix() == panier.getPrixTotal()) {
            paiment.setId(paiment1.getId());
            paiment.setPayedAt(new Date());
            paiment.setPrix(panier.getPrixTotal());
            return paimentDao.save(paiment);
        } else return null;

    }


}
