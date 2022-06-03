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


    @GetMapping("/id/{id}")
    public ProduitBio findById(@PathVariable Long id) {
        return produitBioAdminService.findById(id);
    }

    @PostMapping("/save/{image}")
    public ProduitBio save(@RequestBody ProduitBio produitBio,@PathVariable String image) {
        return produitBioAdminService.save(produitBio, image);
    }

    @GetMapping("/")
    public List<ProduitBio> findAll() {
        return produitBioAdminService.findAll();
    }

    @GetMapping("/nom/{nom}")
    public ProduitBio findByNom(@PathVariable String nom) {
        return produitBioAdminService.findByNom(nom);
    }

    @DeleteMapping("/{nom}")
    public int deleteByNom(@PathVariable String nom) {
        return produitBioAdminService.deleteByNom(nom);
    }

    @PostMapping("/")
    public ProduitBio save(@RequestBody ProduitBio produitBio) {
        return produitBioAdminService.save(produitBio);
    }

    @PutMapping("/")
    public ProduitBio update(@RequestBody ProduitBio produitBio) {
        return produitBioAdminService.update(produitBio);
    }
}
