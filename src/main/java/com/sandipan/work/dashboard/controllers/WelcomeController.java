package com.sandipan.work.dashboard.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class WelcomeController {

    @GetMapping("/getMessage")
    public String getWelcomeMessage(){
        return "Welcome to AWS ECS Dashboard";
    }

    @GetMapping
    public String healthCheck(){
        return "Application is up and running";
    }

    @GetMapping("/version")
    public String getVersion(){
        return "1.0.12";
    }
}
