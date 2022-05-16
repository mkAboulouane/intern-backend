package com.fst.sir.ws.rest.provided.facade.anonymous;

import com.fst.sir.security.bean.User;
import com.fst.sir.security.service.facade.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


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

    @GetMapping("/username/{username}")
    public List<String> getUserRole(@PathVariable String username) {
        User user = userService.findByUsername(username);
        List<String> list = new ArrayList<>();
        user.getRoles().forEach(e -> list.add(e.getAuthority()));
        return list;
    }

}
