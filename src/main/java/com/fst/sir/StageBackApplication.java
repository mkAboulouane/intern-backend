package com.fst.sir;

import com.fst.sir.security.bean.Role;
import com.fst.sir.security.bean.User;
import com.fst.sir.security.common.AuthoritiesConstants;
import com.fst.sir.security.service.facade.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
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
                User user = new User("khalil");
                Role roleForAdmin = new Role();
                roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
                if (user.getRoles() == null)
                    user.setRoles(new ArrayList<>());

                user.getRoles().add(roleForAdmin);
                userService.save(user);
            }
        };
    }
}
