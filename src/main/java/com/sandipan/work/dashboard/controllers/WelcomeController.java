package com.sandipan.work.dashboard.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin("http://localhost:3000")
public class WelcomeController {

    @GetMapping("/getMessage")
    public String getWelcomeMessage(){
        return "Welcome to Dashboard";
    }
}
