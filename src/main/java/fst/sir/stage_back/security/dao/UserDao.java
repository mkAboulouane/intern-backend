package fst.sir.stage_back.security.dao;

import fst.sir.stage_back.security.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByPhone(String phone);

    int deleteByUsername(String username);

    User findByEmail(String email);

}
