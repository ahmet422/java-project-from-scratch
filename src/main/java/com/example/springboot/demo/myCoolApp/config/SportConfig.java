package com.example.springboot.demo.myCoolApp.config;

import com.example.springboot.demo.myCoolApp.common.ICoach;
import com.example.springboot.demo.myCoolApp.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// make an existing third-party class available to Spring Framework as bean
@Configuration // for third party classes, ex SwimCoach assume, you can not change its code. But to make it bean, you can use config class and mark it as bean
public class SportConfig {
    @Bean("aquatic") // expose as a Spring Bean... by default the bean id will be the name of method -> swimCoach, to change it put your own name in parenthesis -> aquatic
    public ICoach swimCoach(){
        return new SwimCoach();
    }

}
