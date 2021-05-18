package com.example.greeting.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.example.greeting.model.Greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private static final String templateOfMessage = "HELLO , %s";
    private final AtomicLong messageCounter = new AtomicLong();

    //Mapping /greeting to create a new object to give a message and id
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "There") String name ){
        //returning new greeting object
        return new Greeting(messageCounter.incrementAndGet() , String.format(templateOfMessage, name));
    }
}
