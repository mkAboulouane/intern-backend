package com.fst.sir.ws.rest.provided.facade.anonymous;

import com.fst.sir.bean.Formation;
import com.fst.sir.service.admin.facade.FormationAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/default")
public class FormationAnonymousRest {
    @Autowired
    private FormationAdminService formationAdminService;






}
