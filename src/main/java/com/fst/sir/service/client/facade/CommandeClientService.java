package com.fst.sir.service.client.facade;

import com.fst.sir.bean.Commande;

import java.util.List;

public interface CommandeClientService {



    Commande findByReference(String reference);

    void deleteByReference(String reference);

    List<Commande> findByUserId();
    List<Commande> findAll();

    Commande save(Commande commande);

    Commande update(Commande commande);

    int delete(Long id);


}
