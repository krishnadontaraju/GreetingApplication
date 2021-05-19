package com.messaging.greeting.model;

public class User {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        String string = (firstName != null ) ? firstName + " " : "";
        string += (lastName != null ) ? lastName : "";
        return string.trim();
    }

	public void setFirstName(String name) {
		this.firstName = firstName;
		
	}
}
