package com.messaging.greeting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.messaging.greeting.model.Greeting;
import com.messaging.greeting.model.User;
import com.messaging.greeting.service.IGreetingService;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
     IGreetingService greetingService;

    //Mapping /greeting to create a new object to give a message and id
    @GetMapping(value ={"","/","/greetingHome"})
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "There") String name ){
        //returning new greeting object
        User user = new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);
    }
}