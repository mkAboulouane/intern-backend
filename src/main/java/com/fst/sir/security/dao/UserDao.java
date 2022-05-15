package com.fst.sir.security.dao;

import com.fst.sir.security.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao  extends JpaRepository<User, Long>{

    User findByPhone(String phone);
    User findByUsername(String username);
    int deleteByUsername(String username);
    User findByEmail(String email);
}
