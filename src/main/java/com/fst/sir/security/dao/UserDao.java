package com.fst.sir.security.dao;

import com.fst.sir.security.bean.User;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findByPhone(String phone);

    User findByUsername(String username);

    int deleteByUsername(String username);

    User findByEmail(String email);
}
