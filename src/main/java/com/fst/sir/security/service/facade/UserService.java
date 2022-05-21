package com.fst.sir.security.service.facade;

import com.fst.sir.security.bean.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserService extends UserDetailsService {

    String getUserRole(String username);

    List<User> findAll();

    User findByUsername(String username);

    User findByPhone(String phone);

    User findById(Long id);

    void deleteById(Long id);

    /*  Client  */
    User save(User user);


//    User savePure(User user);

    /*  Admin  */
    User saveAdmin(User user);

    /*  Gerant  */
    User saveAGENT(User user);

    User update(User user);

    int delete(Long id);

    User findByUsernameWithRoles(String username);

    int  deleteByUsername(String username);

    public UserDetails loadUserByUsername(String username)  ;

}
