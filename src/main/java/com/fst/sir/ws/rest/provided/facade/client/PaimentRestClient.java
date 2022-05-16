package com.fst.sir.ws.rest.provided.facade.client;

import com.fst.sir.bean.Paiment;
import com.fst.sir.service.client.facade.PaimentClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app/paiment")
public class PaimentRestClient {
    @Autowired
    private PaimentClientService paimentClientService;


    @GetMapping("/username/{username}")
    public List<Paiment> findByPanierUserUsername(@PathVariable String username) {
        return paimentClientService.findByPanierUserUsername(username);
    }

    @GetMapping("/reference/{reference}")
    public Paiment findByReference(@PathVariable String reference) {
        return paimentClientService.findByReference(reference);
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return paimentClientService.deleteByReference(reference);
    }

    @PostMapping("/")
    public Paiment save(@RequestBody Paiment paiment) {
        return paimentClientService.save(paiment);
    }

    @PutMapping("/")
    public Paiment update(@RequestBody Paiment paiment) {
        return paimentClientService.update(paiment);
    }
}
