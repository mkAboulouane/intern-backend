package fst.sir.com.security.dao;

import fst.sir.com.security.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByPhone(String phone);

    int deleteByUsername(String username);

    User findByEmail(String email);

}
