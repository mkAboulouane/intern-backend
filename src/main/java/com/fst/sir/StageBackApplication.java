package com.fst.sir;

import com.fst.sir.bean.Congres;
import com.fst.sir.bean.Formation;
import com.fst.sir.bean.ProduitBio;
import com.fst.sir.security.bean.User;
import com.fst.sir.security.service.facade.RoleService;
import com.fst.sir.security.service.facade.UserService;
import com.fst.sir.service.admin.facade.CongresAdminService;
import com.fst.sir.service.admin.facade.FormationAdminService;
import com.fst.sir.service.admin.facade.ProduitBioAdminService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

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
    CommandLineRunner start(UserService userService, RoleService roleService, FormationAdminService formationAdminService, CongresAdminService congresAdminService, ProduitBioAdminService produitBioAdminService) {
        return args -> {

            if (false) {
                int i = 20;
                User userAdmin = new User("admin@gmail.com", "admin", "admin", "admin");
                userService.saveAdmin(userAdmin);

                User userGerant = new User("gerant@gmail.com", "gerant", "gerant", "gerant");
                userService.saveAGENT(userGerant);

                int k=5;
                for (int i1 = 0; i1 < k; i1++) {
                    userService.save( new User("client"+i1+"@gmail.com", "client"+i1, "client"+i1, "client"+i1));
                }




//                for (int i1 = 0; i1 < i; i1++) {
//                    Formation formation = new Formation((int) (Math.random() * 2000), i1 * 3);
//                    formation.setNom("learn java " + i1);
//                    formation.setDescription("Plusieurs variations de Lorem Ipsum peuvent être trouvées ici ou là, mais la majeure partie d'entre elles a été altérée par l'addition d'humour ou de mots aléatoires qui ne ressemblent pas une seconde à du texte standard. Si vous voulez utiliser un passage du Lorem Ipsum, vous devez être sûr qu'il n'y a rien d'embarrassant caché dans le texte.");
//                    formation.setDuree("20");
//                    formationAdminService.save(formation);
//
//                    Congres congres = new Congres("Shishawa Mzoda " + i1);
//                    congres.setNom("Angular " + i1);
//                    congres.setDescription("Plusieurs variations de Lorem Ipsum peuvent être trouvées ici ou là, mais la majeure partie d'entre elles a été altérée par l'addition d'humour ou de mots aléatoires qui ne ressemblent pas une seconde à du texte standard. Si vous voulez utiliser un passage du Lorem Ipsum, vous devez être sûr qu'il n'y a rien d'embarrassant caché dans le texte.");
//                    congres.setEncadrantProf("Ana ana");
//                    congresAdminService.save(congres);
//
//                    ProduitBio produitBio = new ProduitBio(null, "Lantilles " + i1, i1 >= 7, true, true, null,  "L'extrait standard de Lorem Ipsum utilisé depuis le XVIè siècle est reproduit ci-dessous pour les curieux. Les sections 1.10.32 et 1.10.33 du De Finibus Bonorum et Malorum", null, (int)(Math.random() * 1500),  (int)(Math.random() * 5000), null);
//                    produitBioAdminService.save(produitBio);
//

                }
        };
    }
}
