package com.fst.sir.ws.rest.provided.facade.client;

import com.fst.sir.bean.Panier;
import com.fst.sir.service.client.facade.PanierClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app/panier")
public class PanierRestClient {
    @Autowired
    private PanierClientService panierClientService;


    @PostMapping("/")
    public Panier save(@RequestBody Panier panier) {
        return panierClientService.save(panier);
    }

    @PutMapping("/")
    public Panier update(@RequestBody Panier panier) {
        return panierClientService.update(panier);
    }

    @GetMapping("/username/{username}")
    public List<Panier> findByUserUsername(@PathVariable String username) {
        return panierClientService.findByUserUsername(username);
    }
}
