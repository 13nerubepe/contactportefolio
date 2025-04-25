package com.neru.contactfolio.controller;

import com.neru.contactfolio.entities.ContactForm;
import com.neru.contactfolio.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/contact")
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "https://marvelous-biscochitos-8b098a.netlify.app")

public class ContactController {

    private EmailService emailService;


    public ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping( consumes =MediaType.APPLICATION_FORM_URLENCODED_VALUE)

    public ResponseEntity<String> envoyerMessage(@ModelAttribute ContactForm contactForm) {
        try {
            emailService.envoyer(contactForm);
            return ResponseEntity.ok("Message envoyé avec succès !");
        } catch (MailException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erreur d'envoi de l'email : " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Une erreur est survenue : " + e.getMessage());
        }
    }

}
