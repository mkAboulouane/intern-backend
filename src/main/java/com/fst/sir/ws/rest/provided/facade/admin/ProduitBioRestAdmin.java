package com.fst.sir.ws.rest.provided.facade.admin;

import com.fst.sir.bean.ProduitBio;
import com.fst.sir.service.admin.facade.ProduitBioAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/produit-bio")
public class ProduitBioRestAdmin {
    @Autowired
    private ProduitBioAdminService produitBioAdminService;

    @GetMapping("/voir-aussi/{existId}")
    public List<ProduitBio> voirAussi(@PathVariable Long existId) {
        return produitBioAdminService.voirAussi(existId);
    }

    @GetMapping("/id/{id}")
    public ProduitBio findById(@PathVariable Long id) {
        return produitBioAdminService.findById(id);
    }

    @PostMapping("/save/")
    public int save(@RequestBody ProduitBio produitBio) {
        long id = produitBio.getId();
        produitBio.setId(null);
        return produitBioAdminService.save(produitBio,id);
    }

    @GetMapping("/")
    public List<ProduitBio> findAll() {
        return produitBioAdminService.findAll();
    }

    @GetMapping("/nom/{nom}")
    public ProduitBio findByNom(@PathVariable String nom) {
        return produitBioAdminService.findByNom(nom);
    }

    @DeleteMapping("/{id}")
    public int deleteById(@PathVariable Long id) {
        return produitBioAdminService.deleteById(id);
    }

//    @PostMapping("/")
//    public ProduitBio save(@RequestBody ProduitBio produitBio) {
//        return produitBioAdminService.save(produitBio);
//    }

    @PutMapping("/")
    public ProduitBio update(@RequestBody ProduitBio produitBio) {
        return produitBioAdminService.update(produitBio);
    }
}
