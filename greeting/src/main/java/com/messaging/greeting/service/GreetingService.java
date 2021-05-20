package com.messaging.greeting.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.messaging.greeting.model.Greeting;
import com.messaging.greeting.model.User;
import com.messaging.greeting.repository.GreetingRepository;

@Service
public class GreetingService implements IGreetingService{
    private static final String messageTemplate = "Hello %s";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(messageTemplate , (user.toString().isEmpty()) ? "Hello There" : user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet() , message));
    }

    @Override
    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id).get();
    }

	@Override
	public List<Greeting> getAllGreetings() {
		List<Greeting> greetings = new ArrayList<Greeting>();
    	greetingRepository.findAll().forEach(greeting -> greetings.add(greeting));
    	
    	return greetings;
	}

	@Override
	public Greeting updateGreeting(Greeting greeting, Long id, String firstName, String lastName) {
		Greeting newGreeting = null;
		try {
			newGreeting = greetingRepository.findById(id).
													orElseThrow(() -> new AttributeNotFoundException("User not found on :: "+ id));
		} catch (AttributeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		newGreeting.setMessage(String.format(messageTemplate, (user.toString().isEmpty()) ? "Hello There" : user.toString()));
		
		return newGreeting;
		
	}
    
 }
