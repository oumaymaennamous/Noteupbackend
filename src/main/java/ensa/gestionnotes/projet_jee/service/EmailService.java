package ensa.gestionnotes.projet_jee.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class EmailService {

    private JavaMailSender mailSender;
    @Value("$(spring.mail.username)")
    private String from;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendValidationEmail(String email, String validationCode) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(email);
        message.setSubject("Validation de votre inscription");
        message.setText("Votre code de validation est : " + validationCode);
        mailSender.send(message);
    }

    public String generateValidationCode() {
        return UUID.randomUUID().toString(); // Génère un code unique
    }
}