package com.neru.contactfolio.service;

import com.neru.contactfolio.entities.ContactForm;
import jakarta.mail.MessagingException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class EmailService {
    private JavaMailSender mailEmail;

    public EmailService(JavaMailSender sendEmail) {
        this.mailEmail = sendEmail;
    }

    public void envoyer(ContactForm contactForm) throws MessagingException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("bepeneru13@gmail.com");
        mail.setText(
                "Nom :" + contactForm.getNom() + "\n" +
                "Email:" + contactForm.getEmail() + "\n\n" +
                        "Message : \n" + contactForm.getMessage());

        mailEmail.send(mail);

    }
}
