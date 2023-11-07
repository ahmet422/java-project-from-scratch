package com.example.springboot.demo.myCoolApp.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements ICoach {

    @Override
    public String getDailyWorkOut() {
        return "Spin 30 min in battling practice";
    }
}
