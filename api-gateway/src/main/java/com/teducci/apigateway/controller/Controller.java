package com.teducci.apigateway.controller;

import com.teducci.apigateway.service.KeycloakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class Controller {

    @Autowired
    private KeycloakService keycloakService;

    @GetMapping("/user")
    public String index(Principal principal) {
        return principal.getName();
    }

    @GetMapping("/login")
    public Object authentication(@RequestParam("username") String username,
                                 @RequestParam("password") String password) {
        return keycloakService.userLogin(username, password);
    }

}