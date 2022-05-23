package com.fst.sir.service.admin.facade;

import com.fst.sir.bean.Reunion;

import java.util.List;

public interface ReunionAdminService {

    List<Reunion> findAll();

    List<Reunion> findAllVisible();


}
