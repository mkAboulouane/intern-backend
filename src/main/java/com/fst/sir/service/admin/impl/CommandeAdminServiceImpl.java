package com.fst.sir.service.admin.impl;

import com.fst.sir.bean.Commande;
import com.fst.sir.dao.CommandeDao;
import com.fst.sir.enums.EtatCommande;
import com.fst.sir.service.admin.facade.CommandeAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class CommandeAdminServiceImpl implements CommandeAdminService {

    @Autowired
    private CommandeDao commandeDao;
    @Override
    public List<Commande> findAll() {
        return commandeDao.findAll();
    }



    @Override
    public List<Commande> findByEtatCommande(EtatCommande etatCommande) {
        return commandeDao.findByEtatCommande(etatCommande);
    }

    @Override
    public List<Commande> findByUserUsername(String username) {
        return commandeDao.findByUserUsername(username);
    }

    @Override
    public Commande findByReference(String reference) {
        return commandeDao.findByReference(reference);
    }

    @Override
    public int deleteByReference(String reference) {
        return 0;
    }

    @Override
    public Commande save(Commande commande) {
        return null;
    }

    @Override
    public Commande update(Commande commande) {
        return null;
    }
}
