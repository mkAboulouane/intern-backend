package com.fst.sir.security.service.impl;

import com.fst.sir.security.bean.Role;
import com.fst.sir.security.bean.User;
import com.fst.sir.security.common.AuthoritiesConstants;
import com.fst.sir.security.common.SecurityUtil;
import com.fst.sir.security.dao.UserDao;
import com.fst.sir.security.service.facade.RoleService;
import com.fst.sir.security.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleService roleService;

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

/*
    @Override
    public User savePure(User user) {
        User foundedUserByUsername = findByUsername(user.getUsername());
        User foundedUserByEmail = userDao.findByEmail(user.getEmail());
        if (foundedUserByUsername != null || foundedUserByEmail != null) return null;
        else {
            if (user.getPassword() == null || user.getPassword().isEmpty()) {
                user.setPassword(bCryptPasswordEncoder.encode(user.getUsername()));
            } else {
                user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            }
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
            user.setEnabled(true);
            user.setPasswordChanged(false);
            user.setCreatedAt(new Date());

            if (user.getRoles() != null) {
                Collection<Role> roles = new ArrayList<Role>();
                for (Role role : user.getRoles()) {
                    roles.add(roleService.save(role));
                }
                user.setRoles(roles);
            }
            User mySaved = userDao.save(user);
            return mySaved;
        }
    }
*/

    @Override
    public User getCurrentUser() {
        return SecurityUtil.getCurrentUser();
    }

    @Override
    public List<User> findByAuthorities() {
        List<User> users = userDao.findAll();
        List<User> gerants = new ArrayList<>();
        for (User user : users) {
            for (Role authority : user.getAuthorities()) {
                if(authority.getAuthority().equals("AGENT")){
                    gerants.add(user);
                }
            }
        }
        return gerants;
    }

    @Override
    public String getUserRole(String username) {
        User user = findByUsername(username);
        List<String> list = new ArrayList<>();
        user.getRoles().forEach(e -> list.add(e.getAuthority()));
        String result = list.get(0);
        return result;
    }
    private User init(User user){
        User foundedUserByUsername = findByUsername(user.getUsername());
        User foundedUserByEmail = userDao.findByEmail(user.getEmail());
        User foundedUserByPhone = userDao.findByPhone(user.getPhone());
        if (foundedUserByUsername != null || foundedUserByEmail != null || foundedUserByPhone != null) return null;
        else {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
            user.setEnabled(true);
            user.setPasswordChanged(false);
            user.setCreatedAt(new Date());
            return user;
        }
    }

    /*  pour un AGENT */
    @Override
    public User saveAGENT(User user) {
            User userInit = init(user);
        if (userInit==null) return null;
        else {

            Role roleForAdmin = new Role();
            roleForAdmin.setAuthority(AuthoritiesConstants.AGENT);
            userInit.getRoles().add(roleForAdmin);

            if (user.getRoles() != null) {
                Collection<Role> roles = new ArrayList<Role>();
                for (Role role : user.getRoles()) {
                    roles.add(roleService.save(role));
                }
                userInit.setRoles(roles);
            }

            return userDao.save(userInit);
        }
    }

    /*  pour un Admin */
    @Override
    public User saveAdmin(User user) {
        User userInit = init(user);
        if (userInit==null) return null;
        else {

            Role roleForAdmin = new Role();
            roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
            userInit.getRoles().add(roleForAdmin);

            if (userInit.getRoles() != null) {
                Collection<Role> roles = new ArrayList<Role>();
                for (Role role : userInit.getRoles()) {
                    roles.add(roleService.save(role));
                }
                userInit.setRoles(roles);
            }

            return userDao.save(userInit);
        }
    }

    private static void savePic(User user){
            user.setImage(user.getImage());
    }


    @Override
    public User findByPhone(String phone) {
        return userDao.findByPhone(phone);
    }

    @Override
    public List<User> findAll() {
        List<User> users = userDao.findAll();
        List<User> clients = new ArrayList<>();
        for (User user : users) {
            for (Role authority : user.getAuthorities()) {
                if(authority.getAuthority().equals("CLIENT")){
                    clients.add(user);
                }
            }
        }
        return clients;
    }

    @Override
    public User findByUsername(String username) {
        if (username == null)
            return null;
        return userDao.findByUsername(username);
    }

    @Override
    public User findByUsernameWithRoles(String username) {
        if (username == null)
            return null;
        return userDao.findByUsername(username);
    }

    @Override
    @Transactional
    public int deleteByUsername(String username) {
        return userDao.deleteByUsername(username);
    }

    @Override
    public User findById(Long id) {
        if (id == null)
            return null;
        return userDao.getOne(id);
    }

    @Transactional
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public User save(User user) {
        User userInit = init(user);
        if (userInit==null) return null;
        else {
            Role roleForAdmin = new Role();
            roleForAdmin.setAuthority(AuthoritiesConstants.CLIENT);
            userInit.getRoles().add(roleForAdmin);

            if (userInit.getRoles() != null) {
                Collection<Role> roles = new ArrayList<Role>();
                for (Role role : userInit.getRoles()) {
                    roles.add(roleService.save(role));
                }
                userInit.setRoles(roles);
            }


            return userDao.save(userInit);
        }
    }

    @Override
    public User update(User user) {
        User foundedUser = findById(user.getId());
        if (foundedUser == null) return null;
        else {
            foundedUser.setEmail(user.getEmail());
            foundedUser.setUsername(user.getUsername());
            foundedUser.setPrenom(user.getPrenom());
            foundedUser.setNom(user.getNom());
            foundedUser.setEnabled(user.isEnabled());
            foundedUser.setCredentialsNonExpired(user.isCredentialsNonExpired());
            foundedUser.setAccountNonLocked(user.isAccountNonLocked());
            foundedUser.setAccountNonExpired(user.isAccountNonExpired());
            foundedUser.setAuthorities(new ArrayList<>());
            Collection<Role> roles = new ArrayList<Role>();
            savePic(foundedUser);
            for (Role role : user.getRoles()) {
                roles.add(roleService.save(role));
            }
            foundedUser.setRoles(roles);
            return userDao.save(foundedUser);
        }
    }

    @Override
    @Transactional
    public int delete(Long id) {
        User foundedUser = findById(id);
        if (foundedUser == null) return -1;
        userDao.delete(foundedUser);
        return 1;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUsernameWithRoles(username);
    }
}
