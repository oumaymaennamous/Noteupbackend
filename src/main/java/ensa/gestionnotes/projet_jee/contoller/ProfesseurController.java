package ensa.gestionnotes.projet_jee.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professeur")
public class ProfesseurController {
    @GetMapping("/dashboard")
    public String professeurDashboard() {
        return "Bienvenue dans le tableau de bord professeur";
        
    }
}
