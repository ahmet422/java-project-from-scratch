package com.example.springboot.demo.myCoolApp.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // tells Spring which class has to be chosen as bean when there are multiple options. @qualifier has higher priority than @Primary
public class TennisCoach implements ICoach{
    @Override
    public String getDailyWorkOut() {
        return "practice curving for 30 min";
    }
}
