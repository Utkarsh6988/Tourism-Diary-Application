package com.utkarsh.app.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.MessagingException;  // Updated to jakarta.mail
import jakarta.mail.internet.MimeMessage;  // Updated to jakarta.mail
import java.time.LocalDate;
import java.util.Map;

@Component
public class EmailUtils {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public void sendSimpleEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    public void sendHtmlEmail(String to, String subject, String templateName, 
                            Map<String, Object> variables) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        
        Context context = new Context();
        context.setVariables(variables);
        String htmlContent = templateEngine.process(templateName, context);
        
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlContent, true);
        
        mailSender.send(mimeMessage);
    }

    public void sendTicketConfirmation(String email, String attractionName, 
                                     LocalDate visitDate, int quantity) {
        String subject = "Your Ticket Confirmation";
        String text = String.format(
            "You have successfully booked %d ticket(s) for %s on %s",
            quantity, attractionName, visitDate.toString()
        );
        sendSimpleEmail(email, subject, text);
    }
}