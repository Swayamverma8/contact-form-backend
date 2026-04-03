package com.swayam.contact_backend.controller;

import com.swayam.contact_backend.dto.ContactRequest;
import com.swayam.contact_backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public String sendMail(@RequestBody ContactRequest request) {

        emailService.sendEmail(
                request.getName(),
                request.getEmail(),
                request.getOpportunity(),
                request.getMessage()
        );
        return "Email sent successfully!";
    }
}


//handles API requests