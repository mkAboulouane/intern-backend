package com.fst.sir.ws.rest.provided.facade.admin;


import com.fst.sir.bean.Panier;
import com.fst.sir.enums.EtatCommande;
import com.fst.sir.service.admin.facade.PanierAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/paiment")
public class PaimentRestAdmin {
    @Autowired
    private PanierAdminService panierAdminService;

    @GetMapping("/")
    public List<Panier> findAll() {
        return panierAdminService.findAll();
    }

    @GetMapping("/etat/{etatCommande}")
    public List<Panier> findByEtatCommande(@PathVariable EtatCommande etatCommande) {
        return panierAdminService.findByEtatCommande(etatCommande);
    }

    @GetMapping("/client/{username}")
    public List<Panier> findByUserUsername(@PathVariable String username) {
        return panierAdminService.findByUserUsername(username);
    }

    @GetMapping("/panier/{reference}")
    public Panier findByReference(@PathVariable String reference) {
        return panierAdminService.findByReference(reference);
    }

    public int deleteByReference(String reference) {
        return panierAdminService.deleteByReference(reference);
    }

    @PostMapping("/")
    public Panier save(@RequestBody Panier panier) {
        return panierAdminService.save(panier);
    }

    @PutMapping("/")
    public Panier update(@RequestBody Panier panier) {
        return panierAdminService.update(panier);
    }
}
