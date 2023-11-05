package com.example.springboot.demo.myCoolApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for dependency
    private ICoach coach;

    //define a constructor for dependency injection
    // Autowired annotation tells Spring to inject the dependency
    // if you have only 1 constructor then this annotation is optional
    @Autowired
    public DemoController(ICoach coach) {
        this.coach = coach;
    }

    @GetMapping("/dailyWorkOut")
    public String getDailyWorkOut(){
        return this.coach.getDailyWorkOut();
    }
}
