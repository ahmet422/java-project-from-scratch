package com.example.springboot.demo.myCoolApp.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Primary // tells Spring which class has to be chosen as bean when there are multiple options. @qualifier has higher priority than @Primary
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // be default all scopes are singleton
// Prototype beans are lazy by default. There is no need to use the @Lazy annotation for prototype scopes beans.
// For "prototype" scoped beans, Spring does not call the destroy method
public class TennisCoach implements ICoach{
    public TennisCoach() {
        System.out.println("From constructor: " + getClass().getSimpleName());
    }

    // define init method for bean lifecycle
    @PostConstruct
    public void startUp(){
        System.out.println("Start up post construct");
    }

    // define destroy method for bean lifecycle
    @PreDestroy // will be executed when app is being turned off
    public void destroy(){
        System.out.println("destroy");
    }
    @Override
    public String getDailyWorkOut() {
        return "practice curving for 30 min";
    }
}
