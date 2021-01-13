package com.sandipan.work.dashboard.controllers;

import com.sandipan.work.dashboard.service.DashboardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "http://aws-dev-dashboard.s3.amazonaws.com")
public class WelcomeController {

    @Autowired
    DashboardServiceImpl dashboardService;

    @GetMapping("/getMessage")
    public String getWelcomeMessage(){
        return dashboardService.getReleaseNotes();
    }

    @GetMapping
    public int healthCheck(){
        return HttpStatus.OK.value();
    }

    @GetMapping("/version")
    public String getVersion(){
        return "1.0.21";
    }
}
