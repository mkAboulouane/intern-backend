package com.example.stage_back.security.service.impl;

import com.example.stage_back.security.bean.Permission;
import com.example.stage_back.security.dao.PermissionDao;
import com.example.stage_back.security.service.facade.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public Permission save(Permission permission) {
        Permission perm = permissionDao.findByName(permission.getName());
        return perm == null ? permissionDao.save(permission) : perm;
    }


}
