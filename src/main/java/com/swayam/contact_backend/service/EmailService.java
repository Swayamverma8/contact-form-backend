package com.swayam.contact_backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class EmailService {

    @Value("${brevo.api.key}")
    private String brevoApiKey;

    public void sendEmail(String name, String email, String opportunity, String message) {
        try {
            String jsonBody = """
                {
                    "sender": {"name": "Portfolio Contact", "email": "swayamverma.08440@gmail.com"},
                    "to": [{"email": "swayamverma.08440@gmail.com", "name": "Swayam"}],
                    "subject": "New Contact Form Message",
                    "textContent": "Name: %s\\nEmail: %s\\nOpportunity: %s\\nMessage: %s"
                }
                """.formatted(name, email, opportunity, message);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.brevo.com/v3/smtp/email"))
                    .header("Content-Type", "application/json")
                    .header("api-key", brevoApiKey)
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            System.out.println("Brevo response: " + response.statusCode());

        } catch (Exception e) {
            throw new RuntimeException("Failed to send email: " + e.getMessage());
        }
    }
}