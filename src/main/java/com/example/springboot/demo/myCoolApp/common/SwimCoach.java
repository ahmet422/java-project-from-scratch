package com.example.springboot.demo.myCoolApp.common;

import org.springframework.context.annotation.Configuration;

public class SwimCoach implements ICoach{

    public SwimCoach() {
        System.out.println("From constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut() {
        return "Swim laps for 50 min";
    }
}
