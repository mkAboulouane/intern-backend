package com.fst.sir.ws.rest.provided.facade.anonymous;

import com.fst.sir.security.bean.User;
import com.fst.sir.security.common.SecurityUtil;
import com.fst.sir.security.service.facade.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("register")
public class UserRestAnonymous {
    @Autowired
    private UserService userService;

    @ApiOperation("Save Client")
    @PostMapping("/")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }


    @GetMapping("/hello")
    public String hello(@CurrentSecurityContext(expression="authentication?.name")
                        String username) {
        return "Hello, " + username + "!";
    }

    @GetMapping("/online")
    public User getCurrentUser() {
        User user = new User();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            String name = auth.getName();
        }
        return user;

    }

    /*   get User Role   */
    @GetMapping("/role/username/{username}")
    public String getUserRole(@PathVariable String username) {
        return userService.getUserRole(username);
    }

    @GetMapping("/test/")
    public double test(){
        return 323.423;
    }
}
