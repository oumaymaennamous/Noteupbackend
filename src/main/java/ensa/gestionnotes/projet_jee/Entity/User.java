package ensa.gestionnotes.projet_jee.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String role; // "PROFESSEUR" or "ADMIN"
    private String cin;
    private boolean active;
    private boolean validated; // Pour vérifier si l'utilisateur a validé son inscription
    private String validationCode; // Code de validation envoyé par email

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public void setValidationCode(String validationCode) {
        this.validationCode = validationCode;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getCin() {
        return cin;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isValidated() {
        return validated;
    }

    public String getValidationCode() {
        return validationCode;
    }

    public String getEmail() {
        return email;
    }
}
