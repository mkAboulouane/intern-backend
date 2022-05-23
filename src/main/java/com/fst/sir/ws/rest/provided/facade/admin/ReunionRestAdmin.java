package com.fst.sir.ws.rest.provided.facade.admin;

import com.fst.sir.bean.Reunion;
import com.fst.sir.service.admin.facade.ReunionAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin/reunion")
public class ReunionRestAdmin {
    @Autowired
    private ReunionAdminService reunionAdminService;

    @GetMapping("/")
    public List<Reunion> findAll() {
        return reunionAdminService.findAll();
    }

    @GetMapping("/visible")
    public List<Reunion> findAllVisible() {
        return reunionAdminService.findAllVisible();
    }
}
