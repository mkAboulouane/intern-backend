package com.fst.sir.ws.rest.provided.facade.client;


import com.fst.sir.bean.Paiment;
import com.fst.sir.enums.TypePaiment;
import com.fst.sir.service.client.facade.PaimentClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("app/paiment")
public class PaimentRestClient {
    @Autowired
    private PaimentClientService paimentClientService;


    public List<Paiment> findByPanierUserUsername(String username) {
        return paimentClientService.findByPanierUserUsername(username);
    }

    public Paiment findByReference(String reference) {
        return paimentClientService.findByReference(reference);
    }


    public Paiment save(Paiment paiment) {
        return paimentClientService.save(paiment);
    }

    public Paiment update(Paiment paiment) {
        return paimentClientService.update(paiment);
    }
}
