package com.example.stage_back;

import com.example.stage_back.bean.Client;
import com.example.stage_back.bean.Commande;
import com.example.stage_back.dao.ClientDao;
import com.example.stage_back.dao.CommandeDao;
import net.bytebuddy.utility.RandomString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

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

/*
    @Bean
    CommandLineRunner start(CommandeDao commandeDao, ClientDao clientDao){
        return args -> {
            for (int i=0;i<=10;i++){
                clientDao.save(new Client(
                        null, RandomString.make(4),RandomString.make(4)+"@gmail.com","name"+i
                        ,"lastName"+i, UUID.randomUUID().toString(),true,new Date()
                ));
//                commandeDao.save(commande);
            }
        };
    }
    */


}