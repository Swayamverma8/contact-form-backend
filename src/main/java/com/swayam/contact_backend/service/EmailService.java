package com.swayam.contact_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String name, String email, String opportunity, String message) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("swayamverma.08440@gmail.com"); // receiver
        mailMessage.setSubject("New Contact Form Message");
        mailMessage.setText(
                "Name: " + name + "\n" +
                        "Email: " + email + "\n" +
                        "Opportunity: " + opportunity + "\n" +
                        "Message: " + message
        );

        mailSender.send(mailMessage);
    }
}

//contains email sending logic
