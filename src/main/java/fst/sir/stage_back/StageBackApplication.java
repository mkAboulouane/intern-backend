package fst.sir.stage_back;

import fst.sir.stage_back.security.bean.Permission;
import fst.sir.stage_back.security.bean.Role;
import fst.sir.stage_back.security.bean.User;
import fst.sir.stage_back.security.common.AuthoritiesConstants;
import fst.sir.stage_back.security.service.facade.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    CommandLineRunner start(UserService userService) {
        return args -> {
            if (false) {

                Map<String, String> etats = new HashMap<>();
                etats.put("Initialisé", "initialise");
                etats.put("En cours", "encours");
                etats.put("Terminé", "termine");


                // Role admin
                User userForAdmin = new User("khalil","073253724","khalil","khalil");

                Role roleForAdmin = new Role();
                roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
                List<Permission> permissionsForAdmin = new ArrayList<>();
                addPermissionForAdmin(permissionsForAdmin);
                roleForAdmin.setPermissions(permissionsForAdmin);
                if (userForAdmin.getRoles() == null)
                    userForAdmin.setRoles(new ArrayList<>());

                userForAdmin.getRoles().add(roleForAdmin);
                userService.save(userForAdmin);
            }
        };
    }

    private static void addPermissionForAdmin(List<Permission> permissions) {
        permissions.add(new Permission("CategorieProduit.edit"));
        permissions.add(new Permission("CategorieProduit.list"));
        permissions.add(new Permission("CategorieProduit.view"));
        permissions.add(new Permission("CategorieProduit.add"));
        permissions.add(new Permission("CategorieProduit.delete"));
        permissions.add(new Permission("Client.edit"));
        permissions.add(new Permission("Client.list"));
        permissions.add(new Permission("Client.view"));
        permissions.add(new Permission("Client.add"));
        permissions.add(new Permission("Client.delete"));
        permissions.add(new Permission("PaiementTag.edit"));
        permissions.add(new Permission("PaiementTag.list"));
        permissions.add(new Permission("PaiementTag.view"));
        permissions.add(new Permission("PaiementTag.add"));
        permissions.add(new Permission("PaiementTag.delete"));
        permissions.add(new Permission("CommandeTag.edit"));
        permissions.add(new Permission("CommandeTag.list"));
        permissions.add(new Permission("CommandeTag.view"));
        permissions.add(new Permission("CommandeTag.add"));
        permissions.add(new Permission("CommandeTag.delete"));
        permissions.add(new Permission("Produit.edit"));
        permissions.add(new Permission("Produit.list"));
        permissions.add(new Permission("Produit.view"));
        permissions.add(new Permission("Produit.add"));
        permissions.add(new Permission("Produit.delete"));
        permissions.add(new Permission("PaiementDetail.edit"));
        permissions.add(new Permission("PaiementDetail.list"));
        permissions.add(new Permission("PaiementDetail.view"));
        permissions.add(new Permission("PaiementDetail.add"));
        permissions.add(new Permission("PaiementDetail.delete"));
        permissions.add(new Permission("CommandeItem.edit"));
        permissions.add(new Permission("CommandeItem.list"));
        permissions.add(new Permission("CommandeItem.view"));
        permissions.add(new Permission("CommandeItem.add"));
        permissions.add(new Permission("CommandeItem.delete"));
        permissions.add(new Permission("Tag.edit"));
        permissions.add(new Permission("Tag.list"));
        permissions.add(new Permission("Tag.view"));
        permissions.add(new Permission("Tag.add"));
        permissions.add(new Permission("Tag.delete"));
        permissions.add(new Permission("Chercheur.edit"));
        permissions.add(new Permission("Chercheur.list"));
        permissions.add(new Permission("Chercheur.view"));
        permissions.add(new Permission("Chercheur.add"));
        permissions.add(new Permission("Chercheur.delete"));
        permissions.add(new Permission("Commande.edit"));
        permissions.add(new Permission("Commande.list"));
        permissions.add(new Permission("Commande.view"));
        permissions.add(new Permission("Commande.add"));
        permissions.add(new Permission("Commande.delete"));
        permissions.add(new Permission("Paiement.edit"));
        permissions.add(new Permission("Paiement.list"));
        permissions.add(new Permission("Paiement.view"));
        permissions.add(new Permission("Paiement.add"));
        permissions.add(new Permission("Paiement.delete"));
    }


}
