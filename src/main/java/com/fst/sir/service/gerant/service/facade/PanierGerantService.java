package com.fst.sir.service.gerant.service.facade;

import com.fst.sir.bean.Panier;
import com.fst.sir.enums.EtatCommande;

import java.util.List;

public interface PanierGerantService {

    List<Panier> findAll();

    List<Panier> findByEtatCommande(EtatCommande etatCommande);


    List<Panier> findByUserUsername(String username);

    Panier findByReference(String reference);

    int deleteByReference(String reference);

    Panier save(Panier panier);

    Panier update(Panier panier);

}
