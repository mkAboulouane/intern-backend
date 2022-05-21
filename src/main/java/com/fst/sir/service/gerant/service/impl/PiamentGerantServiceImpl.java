package com.fst.sir.service.gerant.service.impl;

import com.fst.sir.bean.Paiment;
import com.fst.sir.bean.Panier;
import com.fst.sir.dao.PaimentDao;
import com.fst.sir.enums.TypePaiment;
import com.fst.sir.service.admin.facade.PanierAdminService;
import com.fst.sir.service.gerant.service.facade.PiamentGerantService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class PiamentGerantServiceImpl implements PiamentGerantService {
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
        if(paiment.getPrix() == panier.getPrixTotal())
        {
            paiment.setPayedAt(new Date());
            paiment.setPrix(panier.getPrixTotal());
            return paimentDao.save(paiment);
        }
        else return null;
    }


}
