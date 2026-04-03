package com.swayam.contact_backend.dto;

public class ContactRequest {

    private String name;
    private String email;
    private String message;
    private String opportunity;

    // Default constructor
    public ContactRequest() {
    }

    // Parameterized constructor
    public ContactRequest(String name, String email, String opportunity, String message) {
        this.name = name;
        this.email = email;
        this.opportunity = opportunity;
        this.message = message;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(String opportunity) {
        this.opportunity = opportunity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


//holds request data (name, email, message)
