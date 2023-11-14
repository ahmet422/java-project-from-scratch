package com.example.springboot.demo.myCoolApp.rest2;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class DemoRestController {

    Logger logger = LoggerFactory.getLogger(DemoRestController.class);
    @GetMapping("/hello")
    public String sayHello(){
        logger.debug("Hey hey Hey");
        return "Hello Universe!";
    }
}
