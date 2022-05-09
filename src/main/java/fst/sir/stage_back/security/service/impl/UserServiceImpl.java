package fst.sir.stage_back.security.service.impl;

import fst.sir.stage_back.security.bean.Permission;
import fst.sir.stage_back.security.bean.Role;
import fst.sir.stage_back.security.bean.User;
import fst.sir.stage_back.security.common.AuthoritiesConstants;
import fst.sir.stage_back.security.dao.UserDao;
import fst.sir.stage_back.security.service.facade.RoleService;
import fst.sir.stage_back.security.service.facade.UserService;
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
    PasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleService roleService;

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
            user.setAccountNonExpired(true);

//            if (user.getRoles() != null) {
//                Collection<Role> roles = new ArrayList<Role>();
//                for (Role role : user.getRoles()) {
//                    roles.add(roleService.save(role));
//                }
//                user.setRoles(roles);
//            }

            User compte = userDao.save(user);
            return compte;
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
            foundedUser.setUpdatedAt(new Date());
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
