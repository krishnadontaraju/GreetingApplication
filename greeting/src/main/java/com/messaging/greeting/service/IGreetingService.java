package com.messaging.greeting.service;

import com.messaging.greeting.model.Greeting;
import com.messaging.greeting.model.User;

public interface IGreetingService {
    Greeting addGreeting(User user);
    Greeting getGreetingById(Long id);

}
