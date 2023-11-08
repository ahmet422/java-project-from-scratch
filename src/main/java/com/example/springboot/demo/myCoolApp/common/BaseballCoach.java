package com.example.springboot.demo.myCoolApp.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy // bean is only initialized if needed for dependency injection
public class BaseballCoach implements ICoach {

    public BaseballCoach() {
        System.out.println("from constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut() {
        return "Spin 30 min in battling practice";
    }
}
