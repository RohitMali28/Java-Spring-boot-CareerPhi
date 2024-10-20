package com.example.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendConfirmationEmail(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Email Confirmation");
        message.setText("Please verify your email address.");
        emailSender.send(message);
    }
}