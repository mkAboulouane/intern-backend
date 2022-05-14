package com.fst.sir.ws.rest.provided.facade.admin;

import com.fst.sir.bean.Formation;
import com.fst.sir.service.admin.facade.FormationAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/formation")
public class FormationRestAdmin {
    @Autowired
    private FormationAdminService formationAdminService;

    @GetMapping("/")
    public List<Formation> findAll() {
        return formationAdminService.findAll();
    }

    @GetMapping("/{nom}")
    public Formation findByNom(@PathVariable String nom) {
        return formationAdminService.findByNom(nom);
    }

    public int deleteByNom(String nom) {
        return formationAdminService.deleteByNom(nom);
    }

    @GetMapping("/encadrant/{encadrant}")
    public List<Formation> findByEncadrantProf(@PathVariable String encadrant) {
        return formationAdminService.findByEncadrantProf(encadrant);
    }

    @PostMapping("/")
    public Formation save(@RequestBody Formation formation) {
        return formationAdminService.save(formation);
    }

    @PutMapping("/")
    public Formation update(@RequestBody Formation formation) {
        return formationAdminService.update(formation);
    }
}
