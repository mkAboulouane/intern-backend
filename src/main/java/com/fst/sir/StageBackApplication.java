package com.fst.sir;

import com.fst.sir.security.bean.Permission;
import com.fst.sir.security.bean.User;
import com.fst.sir.security.service.facade.RoleService;
import com.fst.sir.security.service.facade.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

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

//                 final String str = "admin";

//                User userForAdmin = new User(str,str,str,str);
//                userService.saveAdmin(userForAdmin);

//                Role roleForAdmin = new Role();
//                roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
//                List<Permission> permissionsForAdmin = new ArrayList<>();
//                addPermissionForAdmin(permissionsForAdmin);
//                roleForAdmin.setPermissions(permissionsForAdmin);

//                User userAdmin = new User("admin","admin","admin","admin");
//                if(userAdmin.getRoles()==null)
//                    userAdmin.setRoles(new ArrayList<>());
//                userAdmin.getRoles().add(roleForAdmin);
//                userService.saveAdmin(userAdmin);
//                roleService.save(roleForAdmin);

//                Role roleForGerant = new Role();
//                roleForGerant.setAuthority(AuthoritiesConstants.AGENT);
//                List<Permission> permissionsForGerant = new ArrayList<>();
//                addpermissionsForGerant(permissionsForGerant);
//                roleForGerant.setPermissions(permissionsForGerant);
//                roleService.save(roleForGerant);
//
//                Role roleForClient = new Role();
//                roleForClient.setAuthority(AuthoritiesConstants.CLIENT);
//                List<Permission> permissionsForClient = new ArrayList<>();
//                addPermissionForClient(permissionsForClient);
//                roleForClient.setPermissions(permissionsForClient);
//                roleService.save(roleForClient);


                User userAdmin = new User("admin", "admin", "admin", "admin");
//                if(userAdmin.getRoles()==null)
//                    userAdmin.setRoles(new ArrayList<>());
//                userAdmin.getRoles().add(roleForAdmin);
                userService.saveAdmin(userAdmin);
//
                User userGerant = new User("gerant", "gerant", "gerant", "gerant");
//                if(userGerant.getRoles()==null)
//                    userGerant.setRoles(new ArrayList<>());
//                userGerant.getRoles().add(roleForGerant);
                userService.saveAGENT(userGerant);
//
                User userClient = new User("client", "client", "client", "client");
//                if(userClient.getRoles()==null)
//                    userClient.setRoles(new ArrayList<>());
//                userClient.getRoles().add(roleForClient);
                userService.save(userClient);


            }
        };
    }

    private static void addPermissionForAdmin(List<Permission> permissions) {
        permissions.add(new Permission("Commande.edit"));
        permissions.add(new Permission("Commande.list"));
        permissions.add(new Permission("Commande.view"));
        permissions.add(new Permission("Commande.add"));
        permissions.add(new Permission("Commande.delete"));

        permissions.add(new Permission("Paiment.edit"));
        permissions.add(new Permission("Paiment.list"));
        permissions.add(new Permission("Paiment.view"));
        permissions.add(new Permission("Paiment.add"));
        permissions.add(new Permission("Paiment.delete"));

        permissions.add(new Permission("User.edit"));
        permissions.add(new Permission("User.list"));
        permissions.add(new Permission("User.view"));
        permissions.add(new Permission("User.add"));
        permissions.add(new Permission("User.delete"));

        permissions.add(new Permission("Formation.edit"));
        permissions.add(new Permission("Formation.list"));
        permissions.add(new Permission("Formation.view"));
        permissions.add(new Permission("Formation.add"));
        permissions.add(new Permission("Formation.delete"));

        permissions.add(new Permission("Congres.edit"));
        permissions.add(new Permission("Congres.list"));
        permissions.add(new Permission("Congres.view"));
        permissions.add(new Permission("Congres.add"));
        permissions.add(new Permission("Congres.delete"));

        permissions.add(new Permission("ProduitBio.edit"));
        permissions.add(new Permission("ProduitBio.list"));
        permissions.add(new Permission("ProduitBio.view"));
        permissions.add(new Permission("ProduitBio.add"));
        permissions.add(new Permission("ProduitBio.delete"));


        permissions.add(new Permission("Panier.edit"));
        permissions.add(new Permission("Panier.list"));
        permissions.add(new Permission("Panier.view"));
        permissions.add(new Permission("Panier.add"));
        permissions.add(new Permission("Panier.delete"));

    }


    private static void addpermissionsForGerant(List<Permission> permissions) {
        permissions.add(new Permission("Commande.edit"));
        permissions.add(new Permission("Commande.list"));
        permissions.add(new Permission("Commande.view"));
        permissions.add(new Permission("Commande.add"));

        permissions.add(new Permission("Paiment.list"));
        permissions.add(new Permission("Paiment.view"));
        permissions.add(new Permission("Paiment.add"));

        permissions.add(new Permission("User.list"));
        permissions.add(new Permission("User.view"));
        permissions.add(new Permission("User.add"));

        permissions.add(new Permission("Formation.edit"));
        permissions.add(new Permission("Formation.list"));
        permissions.add(new Permission("Formation.view"));
        permissions.add(new Permission("Formation.add"));
        permissions.add(new Permission("Formation.delete"));

        permissions.add(new Permission("Congres.edit"));
        permissions.add(new Permission("Congres.list"));
        permissions.add(new Permission("Congres.view"));
        permissions.add(new Permission("Congres.add"));
        permissions.add(new Permission("Congres.delete"));

        permissions.add(new Permission("ProduitBio.edit"));
        permissions.add(new Permission("ProduitBio.list"));
        permissions.add(new Permission("ProduitBio.view"));
        permissions.add(new Permission("ProduitBio.add"));
        permissions.add(new Permission("ProduitBio.delete"));


        permissions.add(new Permission("Panier.edit"));
        permissions.add(new Permission("Panier.list"));
        permissions.add(new Permission("Panier.view"));
        permissions.add(new Permission("Panier.add"));
        permissions.add(new Permission("Panier.delete"));


    }


    private static void addPermissionForClient(List<Permission> permissions) {
        permissions.add(new Permission("Commande.edit"));
        permissions.add(new Permission("Commande.view"));
        permissions.add(new Permission("Commande.add"));
        permissions.add(new Permission("Commande.delete"));

        permissions.add(new Permission("Paiment.edit"));
        permissions.add(new Permission("Paiment.list"));
        permissions.add(new Permission("Paiment.view"));
        permissions.add(new Permission("Paiment.add"));

        permissions.add(new Permission("Congres.view"));

        permissions.add(new Permission("ProduitBio.view"));

        permissions.add(new Permission("Formation.view"));

        permissions.add(new Permission("Panier.edit"));
        permissions.add(new Permission("Panier.list"));
        permissions.add(new Permission("Panier.view"));
        permissions.add(new Permission("Panier.add"));
        permissions.add(new Permission("Panier.delete"));

    }

}
