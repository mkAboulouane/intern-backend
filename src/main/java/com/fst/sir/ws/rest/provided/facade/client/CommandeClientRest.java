package com.fst.sir.ws.rest.provided.facade.client;

import com.fst.sir.bean.Commande;
import com.fst.sir.service.client.facade.CommandeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app/commande")
public class CommandeClientRest {
    @Autowired
    private CommandeClientService commandeClientService;

    @GetMapping("/")
    public List<Commande> findAll() {
        return commandeClientService.findAll();
    }

    @GetMapping("/reference/{reference}")
    public Commande findByReference(@PathVariable String reference) {
        return commandeClientService.findByReference(reference);
    }

    @DeleteMapping("/reference/{reference}")
    public void deleteByReference(@PathVariable String reference) {
        commandeClientService.deleteByReference(reference);
    }

    @GetMapping("/user-id")
    public List<Commande> findByUserId() {
        return commandeClientService.findByUserId();
    }

    @PostMapping("/")
    public Commande save(@RequestBody Commande commande) {
        return commandeClientService.save(commande);
    }

    @PutMapping("/")
    public Commande update(@RequestBody Commande commande) {
        return commandeClientService.update(commande);
    }

    @DeleteMapping("/id/{id}")
    public int delete(@PathVariable Long id) {
        return commandeClientService.delete(id);
    }
}
