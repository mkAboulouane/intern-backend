package com.fst.sir.ws.rest.provided.facade.admin;

import com.fst.sir.bean.Panier;
import com.fst.sir.enums.EtatCommande;
import com.fst.sir.service.admin.facade.PanierAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/panier")
public class PanierAdminRest {
    @Autowired
    private PanierAdminService panierAdminService;

    @GetMapping("/")
    public List<Panier> findAll() {
        return panierAdminService.findAll();
    }

    @PostMapping("/")
    public Panier save(@RequestBody Panier panier) {
        return panierAdminService.save(panier);
    }

    @PutMapping("/")
    public Panier update(@RequestBody Panier panier) {
        return panierAdminService.update(panier);
    }

    public List<Panier> findByEtatCommande(EtatCommande etatCommande) {
        return panierAdminService.findByEtatCommande(etatCommande);
    }

    public List<Panier> findByUserUsername(String username) {
        return panierAdminService.findByUserUsername(username);
    }

    public Panier findByReference(String reference) {
        return panierAdminService.findByReference(reference);
    }

    public int deleteByReference(String reference) {
        return panierAdminService.deleteByReference(reference);
    }

}
