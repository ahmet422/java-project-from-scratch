package com.example.springboot.demo.myCoolApp;

import org.springframework.stereotype.Component;
// @Component marks a class as a Spring Bean to make it available for injection
@Component
public class CricketCoach implements ICoach{
    @Override
    public String getDailyWorkOut() {
        return "Practice fast bowling for 15 min!";
    }
}
