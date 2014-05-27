package com.winged.eventcatcher.notifier;


import com.winged.eventcatcher.client.Event;

import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Created by winged on 26/05/14.
 */
public class EventNotifier {

    private static final transient Logger logger = Logger.getLogger(EventNotifier.class.getName());

    private static final String ACCOUNT_USERNAME = "your_mail@gmail.com";
    private static final String ACCOUNT_PASS = "your_password";

    private static final String SMTP_ENABLED = "true";
    private static final String SMTP_AUTH = "true";
    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final String SMTP_PORT = "587";

    private static final String MESSAGE_FORMAT = "You have new notification: \n\"%s\"\nDate: %s";


    public void notify(Object message) {
        logger.info("// ---- Notification about message ---- //");
        logger.info(message.toString());

        sendMail((Event) message);
    }

    private void sendMail(Event event) {
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", SMTP_ENABLED);
        props.put("mail.smtp.auth", SMTP_AUTH);
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(ACCOUNT_USERNAME, ACCOUNT_PASS);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(ACCOUNT_USERNAME));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(event.getEmail())
            );
            message.setSubject("Event Catcher");
            message.setText(String.format(MESSAGE_FORMAT, event.getDescription(), event.getDate().toString()));

            Transport.send(message);

            logger.info("// ------- Message sent");
        } catch (MessagingException e) {
            logger.warning(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
