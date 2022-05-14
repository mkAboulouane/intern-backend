package com.fst.sir.service.admin.impl;

import com.fst.sir.bean.Reunion;
import com.fst.sir.dao.ReunionDao;
import com.fst.sir.service.admin.facade.ReunionAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReunionAdminServiceImpl implements ReunionAdminService {
    @Autowired
    private ReunionDao reunionDao;

    @Override
    public List<Reunion> findAll() {
        return reunionDao.findAll();
    }

    @Override
    public List<Reunion> findAllVisible() {
        return reunionDao.findAllVisible();
    }
}
