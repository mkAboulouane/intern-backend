package com.fst.sir;

import com.fst.sir.security.bean.Permission;
import com.fst.sir.security.bean.Role;
import com.fst.sir.security.bean.User;
import com.fst.sir.security.common.AuthoritiesConstants;
import com.fst.sir.security.service.facade.RoleService;
import com.fst.sir.security.service.facade.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

@SpringBootApplication
@EnableSwagger2
public class StageBackApplication {

    private static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx = SpringApplication.run(StageBackApplication.class, args);
    }

    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }

    @Bean
    CommandLineRunner start(UserService userService, RoleService roleService) {
        return args -> {
            if (true) {
                User user = new User("khalil1","0644424423","khalil1fs","khalil@2022");

                Role roleForAdmin = new Role();
                roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
                List<Permission> permissionsForAdmin = new ArrayList<>();
                addPermissionForAdmin(permissionsForAdmin);
                roleForAdmin.setPermissions(permissionsForAdmin);
                if(user.getRoles()==null)
                    user.setRoles(new ArrayList<>());

                user.getRoles().add(roleForAdmin);
                userService.save(user);

            }
        };
    }

    private static void addPermissionForClient(List<Permission> permissions){
        permissions.add(new Permission("Commande.edit"));
        permissions.add(new Permission("Commande.view"));
        permissions.add(new Permission("Commande.list"));

        permissions.add(new Permission("Paiment.edit"));
        permissions.add(new Permission("Paiment.view"));
        permissions.add(new Permission("Paiment.list"));

        permissions.add(new Permission("ProduitBio.edit"));
        permissions.add(new Permission("ProduitBio.view"));
        permissions.add(new Permission("ProduitBio.list"));
    }
    private static void addPermissionForAdmin(List<Permission> permissions){

        permissions.add(new Permission("Commande.edit"));
        permissions.add(new Permission("Commande.view"));
        permissions.add(new Permission("Commande.list"));
        permissions.add(new Permission("Commande.delete"));
        permissions.add(new Permission("Commande.add"));
        
        permissions.add(new Permission("Paiment.edit"));
        permissions.add(new Permission("Paiment.view"));
        permissions.add(new Permission("Paiment.list"));
        permissions.add(new Permission("Paiment.delete"));
        permissions.add(new Permission("Paiment.add"));        
        
        permissions.add(new Permission("Formation.edit"));
        permissions.add(new Permission("Formation.view"));
        permissions.add(new Permission("Formation.list"));
        permissions.add(new Permission("Formation.delete"));
        permissions.add(new Permission("Formation.add")); 
        
        permissions.add(new Permission("ProduitBio.edit"));
        permissions.add(new Permission("ProduitBio.view"));
        permissions.add(new Permission("ProduitBio.list"));
        permissions.add(new Permission("ProduitBio.delete"));
        permissions.add(new Permission("ProduitBio.add"));
        
        permissions.add(new Permission("Congres.edit"));
        permissions.add(new Permission("Congres.view"));
        permissions.add(new Permission("Congres.list"));
        permissions.add(new Permission("Congres.delete"));
        permissions.add(new Permission("Congres.add"));  
        
        permissions.add(new Permission("Reunion.edit"));
        permissions.add(new Permission("Reunion.view"));
        permissions.add(new Permission("Reunion.list"));
        permissions.add(new Permission("Reunion.delete"));
        permissions.add(new Permission("Reunion.add"));
        
        
        
       }
}
