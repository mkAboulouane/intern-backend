package com.fst.sir.ws.rest.provided.facade.gerant;

import com.fst.sir.bean.Congres;
import com.fst.sir.service.admin.facade.CongresAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/congres")
public class CongresRestGerant {

    @GetMapping("/{nom}")
    public Congres findByNom(@PathVariable String nom) {
        return congresAdminService.findByNom(nom);
    }

    @DeleteMapping("/{nom}")
    public int deleteByNom(@PathVariable String nom) {
        return congresAdminService.deleteByNom(nom);
    }


    @GetMapping("/encadrant/{encadrant}")
    public List<Congres> findByEncadrantProf(@PathVariable String encadrant) {
        return congresAdminService.findByEncadrantProf(encadrant);
    }

    @GetMapping("/")
    public List<Congres> findAll() {
        return congresAdminService.findAll();
    }

    @PostMapping("/")
    public Congres save(@RequestBody Congres congres) {
        return congresAdminService.save(congres);
    }

    @PutMapping("/")
    public Congres update(@RequestBody Congres congres) {
        return congresAdminService.update(congres);
    }

    @Autowired
    private CongresAdminService congresAdminService;

}
