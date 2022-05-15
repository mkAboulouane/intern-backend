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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

                // Role admin
                User userForClient = new User("adam","asdd","asdasd","06327813");

                Role roleForGerant = new Role();
                roleForGerant.setAuthority(AuthoritiesConstants.AGENT);
                List<Permission> permissionsForClient = new ArrayList<>();
                addPermissionForGerant(permissionsForClient);
                roleForGerant.setPermissions(permissionsForClient);
                if (userForClient.getRoles() == null)
                    userForClient.setRoles(new ArrayList<>());

                userForClient.getRoles().add(roleForGerant);
                userService.save(userForClient);
            }
        };
    }

    private static void addPermissionForGerant(List<Permission> permissions) {
        permissions.add(new Permission("DisciplineScientifiqueChercheur.edit"));
        permissions.add(new Permission("DisciplineScientifiqueChercheur.list"));
        permissions.add(new Permission("DisciplineScientifiqueChercheur.view"));
        permissions.add(new Permission("DisciplineScientifiqueChercheur.add"));
        permissions.add(new Permission("DisciplineScientifiqueChercheur.delete"));
        permissions.add(new Permission("KeyWord.edit"));
        permissions.add(new Permission("KeyWord.list"));
        permissions.add(new Permission("KeyWord.view"));
        permissions.add(new Permission("KeyWord.add"));
        permissions.add(new Permission("KeyWord.delete"));
        permissions.add(new Permission("Distinction.edit"));
        permissions.add(new Permission("Distinction.list"));
        permissions.add(new Permission("Distinction.view"));
        permissions.add(new Permission("Distinction.add"));
        permissions.add(new Permission("Distinction.delete"));
        permissions.add(new Permission("DisciplineScientifiqueParent.edit"));
        permissions.add(new Permission("DisciplineScientifiqueParent.list"));
        permissions.add(new Permission("DisciplineScientifiqueParent.view"));
        permissions.add(new Permission("DisciplineScientifiqueParent.add"));
        permissions.add(new Permission("DisciplineScientifiqueParent.delete"));
        permissions.add(new Permission("DisciplineScientifique.edit"));
        permissions.add(new Permission("DisciplineScientifique.list"));
        permissions.add(new Permission("DisciplineScientifique.view"));
        permissions.add(new Permission("DisciplineScientifique.add"));
        permissions.add(new Permission("DisciplineScientifique.delete"));
        permissions.add(new Permission("DistinctionDisciplineScientifique.edit"));
        permissions.add(new Permission("DistinctionDisciplineScientifique.list"));
        permissions.add(new Permission("DistinctionDisciplineScientifique.view"));
        permissions.add(new Permission("DistinctionDisciplineScientifique.add"));
        permissions.add(new Permission("DistinctionDisciplineScientifique.delete"));
        permissions.add(new Permission("DisciplineScientifiqueErcAssociation.edit"));
        permissions.add(new Permission("DisciplineScientifiqueErcAssociation.list"));
        permissions.add(new Permission("DisciplineScientifiqueErcAssociation.view"));
        permissions.add(new Permission("DisciplineScientifiqueErcAssociation.add"));
        permissions.add(new Permission("DisciplineScientifiqueErcAssociation.delete"));
        permissions.add(new Permission("IdentifiantAuteurExpert.edit"));
        permissions.add(new Permission("IdentifiantAuteurExpert.list"));
        permissions.add(new Permission("IdentifiantAuteurExpert.view"));
        permissions.add(new Permission("IdentifiantAuteurExpert.add"));
        permissions.add(new Permission("IdentifiantAuteurExpert.delete"));
    }


/*    private static void addPermissionForAdmin(List<Permission> permissions){
        permissions.add(new Permission("DisciplineScientifiqueChercheur.edit"));
        permissions.add(new Permission("DisciplineScientifiqueChercheur.list"));
        permissions.add(new Permission("DisciplineScientifiqueChercheur.view"));
        permissions.add(new Permission("DisciplineScientifiqueChercheur.add"));
        permissions.add(new Permission("DisciplineScientifiqueChercheur.delete"));
        permissions.add(new Permission("KeyWord.edit"));
        permissions.add(new Permission("KeyWord.list"));
        permissions.add(new Permission("KeyWord.view"));
        permissions.add(new Permission("KeyWord.add"));
        permissions.add(new Permission("KeyWord.delete"));
        permissions.add(new Permission("Distinction.edit"));
        permissions.add(new Permission("Distinction.list"));
        permissions.add(new Permission("Distinction.view"));
        permissions.add(new Permission("Distinction.add"));
        permissions.add(new Permission("Distinction.delete"));
        permissions.add(new Permission("DisciplineScientifiqueParent.edit"));
        permissions.add(new Permission("DisciplineScientifiqueParent.list"));
        permissions.add(new Permission("DisciplineScientifiqueParent.view"));
        permissions.add(new Permission("DisciplineScientifiqueParent.add"));
        permissions.add(new Permission("DisciplineScientifiqueParent.delete"));
        permissions.add(new Permission("DisciplineScientifique.edit"));
        permissions.add(new Permission("DisciplineScientifique.list"));
        permissions.add(new Permission("DisciplineScientifique.view"));
        permissions.add(new Permission("DisciplineScientifique.add"));
        permissions.add(new Permission("DisciplineScientifique.delete"));
        permissions.add(new Permission("DistinctionDisciplineScientifique.edit"));
        permissions.add(new Permission("DistinctionDisciplineScientifique.list"));
        permissions.add(new Permission("DistinctionDisciplineScientifique.view"));
        permissions.add(new Permission("DistinctionDisciplineScientifique.add"));
        permissions.add(new Permission("DistinctionDisciplineScientifique.delete"));
        permissions.add(new Permission("DisciplineScientifiqueErcAssociation.edit"));
        permissions.add(new Permission("DisciplineScientifiqueErcAssociation.list"));
        permissions.add(new Permission("DisciplineScientifiqueErcAssociation.view"));
        permissions.add(new Permission("DisciplineScientifiqueErcAssociation.add"));
        permissions.add(new Permission("DisciplineScientifiqueErcAssociation.delete"));
        permissions.add(new Permission("IdentifiantAuteurExpert.edit"));
        permissions.add(new Permission("IdentifiantAuteurExpert.list"));
        permissions.add(new Permission("IdentifiantAuteurExpert.view"));
        permissions.add(new Permission("IdentifiantAuteurExpert.add"));
        permissions.add(new Permission("IdentifiantAuteurExpert.delete"));
        permissions.add(new Permission("IdentifiantRecherche.edit"));
        permissions.add(new Permission("IdentifiantRecherche.list"));
        permissions.add(new Permission("IdentifiantRecherche.view"));
        permissions.add(new Permission("IdentifiantRecherche.add"));
        permissions.add(new Permission("IdentifiantRecherche.delete"));
        permissions.add(new Permission("Chercheur.edit"));
        permissions.add(new Permission("Chercheur.list"));
        permissions.add(new Permission("Chercheur.view"));
        permissions.add(new Permission("Chercheur.add"));
        permissions.add(new Permission("Chercheur.delete"));
        permissions.add(new Permission("EnjeuxIrdChercheur.edit"));
        permissions.add(new Permission("EnjeuxIrdChercheur.list"));
        permissions.add(new Permission("EnjeuxIrdChercheur.view"));
        permissions.add(new Permission("EnjeuxIrdChercheur.add"));
        permissions.add(new Permission("EnjeuxIrdChercheur.delete"));
        permissions.add(new Permission("DisciplineScientifiqueErcParent.edit"));
        permissions.add(new Permission("DisciplineScientifiqueErcParent.list"));
        permissions.add(new Permission("DisciplineScientifiqueErcParent.view"));
        permissions.add(new Permission("DisciplineScientifiqueErcParent.add"));
        permissions.add(new Permission("DisciplineScientifiqueErcParent.delete"));
        permissions.add(new Permission("EnjeuxIrd.edit"));
        permissions.add(new Permission("EnjeuxIrd.list"));
        permissions.add(new Permission("EnjeuxIrd.view"));
        permissions.add(new Permission("EnjeuxIrd.add"));
        permissions.add(new Permission("EnjeuxIrd.delete"));
        permissions.add(new Permission("SemanticRelationship.edit"));
        permissions.add(new Permission("SemanticRelationship.list"));
        permissions.add(new Permission("SemanticRelationship.view"));
        permissions.add(new Permission("SemanticRelationship.add"));
        permissions.add(new Permission("SemanticRelationship.delete"));
        permissions.add(new Permission("EtatEtapeCampagne.edit"));
        permissions.add(new Permission("EtatEtapeCampagne.list"));
        permissions.add(new Permission("EtatEtapeCampagne.view"));
        permissions.add(new Permission("EtatEtapeCampagne.add"));
        permissions.add(new Permission("EtatEtapeCampagne.delete"));
        permissions.add(new Permission("DisciplineScientifiqueErc.edit"));
        permissions.add(new Permission("DisciplineScientifiqueErc.list"));
        permissions.add(new Permission("DisciplineScientifiqueErc.view"));
        permissions.add(new Permission("DisciplineScientifiqueErc.add"));
        permissions.add(new Permission("DisciplineScientifiqueErc.delete"));
        permissions.add(new Permission("Campagne.edit"));
        permissions.add(new Permission("Campagne.list"));
        permissions.add(new Permission("Campagne.view"));
        permissions.add(new Permission("Campagne.add"));
        permissions.add(new Permission("Campagne.delete"));
        permissions.add(new Permission("KeyWordDisciplineScientifiqueErc.edit"));
        permissions.add(new Permission("KeyWordDisciplineScientifiqueErc.list"));
        permissions.add(new Permission("KeyWordDisciplineScientifiqueErc.view"));
        permissions.add(new Permission("KeyWordDisciplineScientifiqueErc.add"));
        permissions.add(new Permission("KeyWordDisciplineScientifiqueErc.delete"));
    }


    private static void addPermissionForClient(List<Permission> permissions){
        permissions.add(new Permission("KeyWord.edit"));
        permissions.add(new Permission("KeyWord.list"));
        permissions.add(new Permission("KeyWord.view"));
        permissions.add(new Permission("KeyWord.add"));
        permissions.add(new Permission("KeyWord.delete"));
        permissions.add(new Permission("Distinction.edit"));
        permissions.add(new Permission("Distinction.list"));
        permissions.add(new Permission("Distinction.view"));
        permissions.add(new Permission("Distinction.add"));
        permissions.add(new Permission("Distinction.delete"));
        permissions.add(new Permission("DisciplineScientifiqueParent.edit"));
        permissions.add(new Permission("DisciplineScientifiqueParent.list"));
        permissions.add(new Permission("DisciplineScientifiqueParent.view"));
        permissions.add(new Permission("DisciplineScientifiqueParent.add"));
        permissions.add(new Permission("DisciplineScientifiqueParent.delete"));
        permissions.add(new Permission("DisciplineScientifique.edit"));
        permissions.add(new Permission("DisciplineScientifique.list"));
        permissions.add(new Permission("DisciplineScientifique.view"));
        permissions.add(new Permission("DisciplineScientifique.add"));
        permissions.add(new Permission("DisciplineScientifique.delete"));
        permissions.add(new Permission("DistinctionDisciplineScientifique.edit"));
        permissions.add(new Permission("DistinctionDisciplineScientifique.list"));
        permissions.add(new Permission("DistinctionDisciplineScientifique.view"));

    }*/

    }
