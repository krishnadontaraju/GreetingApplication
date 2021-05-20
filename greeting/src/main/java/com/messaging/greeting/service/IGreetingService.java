package com.messaging.greeting.service;

import java.util.List;

import com.messaging.greeting.model.Greeting;
import com.messaging.greeting.model.User;

public interface IGreetingService {
    Greeting addGreeting(User user);
    Greeting getGreetingById(Long id);
    List<Greeting> getAllGreetings();
	Greeting updateGreeting(Greeting greeting, Long id, String firstName, String lastName);
	
}
