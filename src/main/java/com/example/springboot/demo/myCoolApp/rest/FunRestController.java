package com.example.springboot.demo.myCoolApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // inject properties coach.name and team.name
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    // expose team info
    @GetMapping("/teamInfo")
    public String teamIfo(){
        return "Coach name: " + coachName + " and team name: " + teamName;
    }

    @GetMapping("/")
    public String sayHello(){
        return "Hello World!!!";
    }
}
