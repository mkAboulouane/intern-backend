package com.fst.sir.service.client.impl;

import com.fst.sir.bean.Formation;
import com.fst.sir.bean.Panier;
import com.fst.sir.bean.ProduitPanierItem;
import com.fst.sir.dao.PanierDao;
import com.fst.sir.enums.EtatCommande;
import com.fst.sir.security.bean.User;
import com.fst.sir.security.common.SecurityUtil;
import com.fst.sir.security.service.facade.UserService;
import com.fst.sir.service.admin.facade.FormationAdminService;
import com.fst.sir.service.client.facade.PanierClientService;
import com.fst.sir.service.client.facade.ProduitPanierItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class PanierClientServiceImpl implements PanierClientService {
    @Autowired
    private PanierDao panierDao;

    @Autowired
    private FormationAdminService formationAdminService;
    @Autowired
    private ProduitPanierItemService produitPanierItemService;
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
        User user = SecurityUtil.getCurrentUser();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User usr = (User) auth.getPrincipal();
//        User user = userService.findByUsername(usr.getUsername());
        if (user == null) {
            return null;
        } else {
            AtomicReference<Double> total= new AtomicReference<>(0D);
            panier.setUser(user);
            if (panier.getFormation() != null && panier.getFormation().getNom()!=null ) {
                Formation formation = formationAdminService.findByNom(panier.getFormation().getNom());
                panier.setFormation(formation);
                total.updateAndGet(v -> v + formation.getPrix());
            }
            panier.setDateAjout(new Date());
            panier.setEtatCommande(EtatCommande.EN_TRAITMENT);
            if (!panier.getProduitPanierItems().isEmpty()) {
                List<ProduitPanierItem> produitPanierItemList = produitPanierItemService.save(panier.getProduitPanierItems());
                for (ProduitPanierItem produitPanierItem : produitPanierItemList) {
                            total.updateAndGet(v-> v + produitPanierItem.getPrix());
                }
            }
             panier.setPrixTotal(total.get());
            return panierDao.save(panier);
        }
    }

    @Override
    public Panier update(Panier panier) {
        Panier entity = findByReference(panier.getReference());
        User user = SecurityUtil.getCurrentUser();
        if (user == null || entity == null) {
            return null;
        } else {
            panier.setId(entity.getId());
            panier.setUser(user);
            Formation formation = formationAdminService.findByNom(panier.getFormation().getNom());
            if (formation != null) {
                panier.setFormation(formation);
            }
            panier.setDateAjout(new Date());
            panier.setEtatCommande(EtatCommande.EN_TRAITMENT);
            panier.setPrixTotal(formation.getPrix());
            Panier panier1 = panierDao.save(panier);
            if (panier.getProduitPanierItems() != null) {
                List<ProduitPanierItem> produitPanierItemList = new ArrayList<>();
                panier.getProduitPanierItems().forEach(e -> produitPanierItemList.add(produitPanierItemService.save(e)));
                produitPanierItemList.forEach(e -> panier1.setPrixTotal(e.getPrix() + panier1.getPrixTotal()));
//                produitPanierItemList.forEach(e -> panier1.setPrixTotal(e.getPrix() + panier1.getPrixTotal()));
                return panier1;
            }
            return panier;
        }

    }
}
