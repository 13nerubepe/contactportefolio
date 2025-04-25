package com.neru.contactfolio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Properties;

public class JavaConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/contact")
                .allowedOrigins("https://marvelous-biscochitos-8b098a.netlify.app") // Remplacer par ton domaine frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Méthodes HTTP autorisées
                .allowedHeaders("*") // En-têtes autorisés
                .allowCredentials(true); // Autoriser l'envoi de cookies
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);  // Port pour STARTTLS
        mailSender.setUsername("bepeneru13@gmail.com");  // Ton adresse Gmail
        mailSender.setPassword("aquf xhbh xztu fkom");    // Ton mot de passe

        // Propriétés de sécurité pour STARTTLS
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");  // Active STARTTLS
        props.put("mail.smtp.ssl.protocols", "TLSv1.2"); // Utiliser TLS 1.2

        return mailSender;
    }
}
