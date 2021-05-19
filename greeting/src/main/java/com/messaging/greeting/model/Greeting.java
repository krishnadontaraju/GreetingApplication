package com.messaging.greeting.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "greetings")
public class Greeting {

    @Id
    private Long id;
    private String message;

    public Greeting(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Greeting() {}

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
