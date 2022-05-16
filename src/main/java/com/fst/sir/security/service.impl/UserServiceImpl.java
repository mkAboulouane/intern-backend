package com.fst.sir.security.service.impl;

import com.fst.sir.security.bean.Role;
import com.fst.sir.security.bean.User;
import com.fst.sir.security.common.AuthoritiesConstants;
import com.fst.sir.security.dao.UserDao;
import com.fst.sir.security.service.facade.RoleService;
import com.fst.sir.security.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

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


    @Override
    public String getUserRole(String username) {
        User user = findByUsername(username);
        List<String> list = new ArrayList<>();
        user.getRoles().forEach(e -> list.add(e.getAuthority()));
        return list.get(0);
    }

    /*  pour un AGENT */
    @Override
    public User saveAGENT(User user) {
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

            Role roleForAdmin = new Role();
            roleForAdmin.setAuthority(AuthoritiesConstants.AGENT);
            user.getRoles().add(roleForAdmin);

            if (user.getRoles() != null) {
                Collection<Role> roles = new ArrayList<Role>();
                for (Role role : user.getRoles()) {
                    roles.add(roleService.save(role));
                }
                user.setRoles(roles);
            }

            User mySaved = userDao.save(user);

            return mySaved;
        }       }

    /*  pour un Admin */
    @Override
    public User saveAdmin(User user) {
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

            Role roleForAdmin = new Role();
            roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
            user.getRoles().add(roleForAdmin);

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



    @Override
    public User findByPhone(String phone) {
        return userDao.findByPhone(phone);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
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

            /*  pour un normal utilisateur on lui a donne le role Client  */

            Role roleForAdmin = new Role();
            roleForAdmin.setAuthority(AuthoritiesConstants.CLIENT);
            user.getRoles().add(roleForAdmin);

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

//            private Chercheur transformToChercheur(User user) {
//            Chercheur chercheur = new Chercheur();
//            chercheur.setUsername(user.getUsername() + "-CH");
//            chercheur.setPassword(user.getPassword());
//            chercheur.setEmail(user.getEmail());
//            chercheur.setPrenom(user.getPrenom());
//            chercheur.setNom(user.getNom());
//            chercheur.getRoles().addAll(user.getRoles());
//            chercheur.setAccountNonExpired(true);
//            chercheur.setAccountNonLocked(true);
//            chercheur.setCredentialsNonExpired(true);
//            chercheur.setEnabled(true);
//            chercheur.setPasswordChanged(false);
//            chercheur.setCreatedAt(new Date());
//            return chercheur;
//            }

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
