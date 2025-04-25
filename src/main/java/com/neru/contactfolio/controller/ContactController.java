package com.neru.contactfolio.controller;

import com.neru.contactfolio.entities.ContactForm;
import com.neru.contactfolio.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/contact")
@CrossOrigin(origins = "https://marvelous-biscochitos-8b098a.netlify.app")
public class ContactController {

    private EmailService emailService;


    public ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<String> envoyerMessage(@RequestBody ContactForm contactForm) throws MessagingException {
        try {
            emailService.envoyer(contactForm);
            return ResponseEntity.ok("Message envoyé avec succès !");
        } catch (Exception e) {
            e.printStackTrace(); // Pour avoir plus de détails en console
            return ResponseEntity.status(500).body("Erreur lors de l'envoi de l'email : " + e.getMessage());
        }
    }
}
