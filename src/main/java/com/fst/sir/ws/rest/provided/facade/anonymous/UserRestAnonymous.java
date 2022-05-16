package com.fst.sir.ws.rest.provided.facade.anonymous;

import com.fst.sir.security.bean.User;
import com.fst.sir.security.service.facade.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



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

}
