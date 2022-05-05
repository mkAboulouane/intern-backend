package com.example.stage_back;

import com.example.stage_back.bean.Commande;
import com.example.stage_back.dao.CommandeDao;
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
      ctx =  SpringApplication.run(StageBackApplication.class, args);
    }
    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }

//    @Bean
//    CommandLineRunner start(CommandeDao commandeDao){
//        return args -> {
//            for (int i=0;i<=10;i++){
//                Commande commande = new Commande(null);
//                commandeDao.save(commande);
//            }
//        };
//    }

}
