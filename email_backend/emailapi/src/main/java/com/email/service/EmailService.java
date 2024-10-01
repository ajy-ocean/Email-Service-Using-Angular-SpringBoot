package com.email.service;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailService {

    // Method to send email using RediffPro
    public boolean sendEmailUsingRediffPro(String subject, String message, String to) {
        boolean flag = false;

        String from = "sender_rediffmail"; // Replace with your RediffPro email address
        String host = "smtp.rediffmailpro.com"; // RediffPro SMTP server
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587"); // Port for TLS
        properties.put("mail.smtp.starttls.enable", "true"); // Enable TLS
        properties.put("mail.smtp.auth", "true"); // Enable authentication

        // Use RediffPro email authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sender_rediffmail", "your_password");
            }
        });
        session.setDebug(true);
        MimeMessage msg = new MimeMessage(session);

        try {
            msg.setFrom(from);
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setSubject(subject);
            msg.setText(message);
            Transport.send(msg);
            System.out.println("Email sent via RediffPro..............");
            flag = true;
        } catch (MessagingException e) {
            e.printStackTrace(); // Log the full stack trace for troubleshooting
        } catch (Exception e) {
            e.printStackTrace(); // Log any other exceptions
        }
        return flag;
    }

    // Method to send email using Gmail
//    public boolean sendEmailUsingGmail(String subject, String message, String to) {
//        boolean flag = false;
//
//        String from = "ajay@gmail.com"; // Replace with your Gmail address
//        String host = "smtp.gmail.com"; // Gmail SMTP server
//        Properties properties = System.getProperties();
//        properties.put("mail.smtp.host", host);
//        properties.put("mail.smtp.port", "465"); // Port for SSL
//        properties.put("mail.smtp.ssl.enable", "true"); // Enable SSL
//        properties.put("mail.smtp.auth", "true"); // Enable authentication
//
//        // Use App Password for Gmail authentication
//        Session session = Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                /*
//                    Provide a 16-character long app password not your Google account password
//                    watch video on how to generate an app password
//                */
//                return new PasswordAuthentication("ajay@gmail.com", "your_app_password"); // Use your generated App Password here
//            }
//        });
//        session.setDebug(true);
//        MimeMessage msg = new MimeMessage(session);
//
//        try {
//            msg.setFrom(from);
//            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//            msg.setSubject(subject);
//            msg.setText(message);
//            Transport.send(msg);
//            System.out.println("Email sent via Gmail..............");
//            flag = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return flag;
//    }
}
