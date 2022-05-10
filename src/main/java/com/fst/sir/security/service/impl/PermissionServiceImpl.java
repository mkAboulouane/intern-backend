package com.fst.sir.security.service.impl;

import com.fst.sir.security.bean.Permission;
import com.fst.sir.security.dao.PermissionDao;
import com.fst.sir.security.service.facade.PermissionService;
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
