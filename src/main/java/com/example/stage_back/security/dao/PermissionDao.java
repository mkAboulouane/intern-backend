package com.example.stage_back.security.dao;

import com.example.stage_back.security.bean.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionDao extends JpaRepository<Permission, Long> {
    public Permission findByName(String name);
}