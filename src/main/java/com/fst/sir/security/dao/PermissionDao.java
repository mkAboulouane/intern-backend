package com.fst.sir.security.dao;

import com.fst.sir.security.bean.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionDao extends JpaRepository<Permission, Long> {
    Permission findByName(String name);
}