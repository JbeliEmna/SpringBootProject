package com.jbeli.securite.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender {

    private final JavaMailSender mailSender;
    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
    @Override
    @Async
    public void send(String to, String email) {
        try{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        helper.setText(email , true);
        helper.setTo(to);
        helper.setSubject("validez votre email");
        helper.setFrom("votre_adresse_email@example.com");
        mailSender.send(mimeMessage);
        }
        catch (MessagingException e)
        {
            LOGGER.error("échec de l'envoi de l'e-mail" , e);
            throw new IllegalStateException("échec de l'envoi de l'e-mail");
        }

    }
}
