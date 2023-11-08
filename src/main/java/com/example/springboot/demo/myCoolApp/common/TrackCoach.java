package com.example.springboot.demo.myCoolApp.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements ICoach{

    public TrackCoach() {
        System.out.println("From constructor: " + getClass().getSimpleName() );
    }

    @Override
    public String getDailyWorkOut() {
        return "run a hard 5k";
    }
}
