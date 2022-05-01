package com.example.stage_back.security.common;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.stream.Stream;

public class SecurityUtil {

//    public static User getCurrentUser() {
//        UserService userService = FaaApplication.getCtx().getBean(UserService.class);
//
//        SecurityContext securityContext = SecurityContextHolder.getContext();
//        Object user = securityContext.getAuthentication().getPrincipal();
//        System.out.println(user);
//        if (user instanceof String) {
//            return userService.findByUsername((String) user);
//        } else if (user instanceof User) {
//            return (User) user;
//        } else {
//            return null;
//        }
//    }


    public static boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null &&
                getAuthorities(authentication).noneMatch(AuthoritiesConstants.ANONYMOUS::equals);
    }


    public static boolean isCurrentUserInRole(String authority) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null &&
                getAuthorities(authentication).anyMatch(authority::equals);
    }

    private static Stream<String> getAuthorities(Authentication authentication) {
        return authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority);
    }

}