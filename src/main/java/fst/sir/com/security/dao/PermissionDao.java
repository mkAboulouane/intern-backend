package fst.sir.com.security.dao;

import fst.sir.com.security.bean.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionDao extends JpaRepository<Permission, Long> {
    public Permission findByName(String name);
}