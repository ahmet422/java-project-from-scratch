package com.example.springboot.demo.myCoolApp.rest;

import com.example.springboot.demo.myCoolApp.common.ICoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for dependency
    private ICoach coach;
//    private ICoach coach2;

    //define a constructor for dependency injection
    // Autowired annotation tells Spring to inject the dependency
    // if you have only 1 constructor then this annotation is optional

    // @Qualifier("baseballCoach")  is helping to tell to spring which coach class should be selected...
    @Autowired
    public DemoController(@Qualifier("aquatic") ICoach coach) {
        System.out.println("From Constructor: " + getClass().getSimpleName());
        this.coach = coach;
    }

//    @Autowired
//    public DemoController(@Qualifier("tennisCoach") ICoach coach, @Qualifier("tennisCoach") ICoach coach2) {
//        System.out.println("From Constructor: " + getClass().getSimpleName());
//        this.coach = coach;
//        this.coach2 = coach2;
//        System.out.printf("comparing beans: " + (coach==coach2));
//    }

    // example of setter injection
//    @Autowired
//    public void setCoach(ICoach coach) {
//        this.coach = coach;
//    }

    @GetMapping("/dailyWorkOut")
    public String getDailyWorkOut(){
        return this.coach.getDailyWorkOut();
    }
}
