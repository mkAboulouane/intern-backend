package com.fst.sir.service.admin.impl;

import com.fst.sir.bean.Panier;
import com.fst.sir.dao.PanierDao;
import com.fst.sir.enums.EtatCommande;
import com.fst.sir.security.bean.User;
import com.fst.sir.security.service.facade.UserService;
import com.fst.sir.service.admin.facade.PanierAdminService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Access;
import java.util.List;

public class PanierAdminServiceImpl implements PanierAdminService {
    @Autowired
    private PanierDao panierDao;

    @Autowired
    private UserService userService;

    @Override
    public List<Panier> findAll() {
        return panierDao.findAll();
    }

    @Override
    public List<Panier> findByEtatCommande(EtatCommande etatCommande) {
        return panierDao.findByEtatCommande(etatCommande);
    }

    @Override
    public List<Panier> findByUserUsername(String username) {
        return panierDao.findByUserUsername(username);
    }

    @Override
    public Panier findByReference(String reference) {
        return panierDao.findByReference(reference);
    }

    @Override
    public int deleteByReference(String reference) {
        return 0;
    }

    @Override
    public Panier save(Panier panier) {
        User user =  userService.findByUsername(panier.getUser().getUsername());
        if (user == null) {
            return null;
        }
        else {



            return panier;
        }
    }

    @Override
    public Panier update(Panier panier) {
        return null;
    }
}
