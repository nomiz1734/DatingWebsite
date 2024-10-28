
package model;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import model.EmailPropety.EmailProperty;

public class EmailService implements IJavamail {

    @Override
    public boolean send(String to, String subject, String messageContent) {

        // Get properties object
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", EmailProperty.HOST_NAME);
        props.put("mail.smtp.socketFactory.port", EmailProperty.SSL_PORT);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.port", EmailProperty.SSL_PORT);

        // get Session
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EmailProperty.APP_EMAIL, EmailProperty.APP_PASSWORD);
            }
        });

        // compose message
        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            mimeMessage.setSubject(subject, "UTF-8"); // Set charset to UTF-8 for subject
//            mimeMessage.setText(messageContent, "UTF-8"); // Set charset to UTF-8 for message
            mimeMessage.setContent(messageContent, "text/html; charset=UTF-8");
            // send message
            Transport.send(mimeMessage);
            return true;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
