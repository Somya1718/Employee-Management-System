package com.security.login.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Home {

    @GetMapping("/home")
    public String greet(HttpServletRequest request){
        return "This is your login page   " +request.getSession().getId();
    }
}
