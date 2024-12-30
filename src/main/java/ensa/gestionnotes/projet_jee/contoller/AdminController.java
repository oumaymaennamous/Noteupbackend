package ensa.gestionnotes.projet_jee.contoller;

import ensa.gestionnotes.projet_jee.Entity.Filiere;
import ensa.gestionnotes.projet_jee.Entity.Professeur;
import ensa.gestionnotes.projet_jee.Entity.Promo;
import ensa.gestionnotes.projet_jee.Entity.Semestre;
import ensa.gestionnotes.projet_jee.dto.EtudiantDTO;
import ensa.gestionnotes.projet_jee.dto.EtudiantDtoReponse;
import ensa.gestionnotes.projet_jee.dto.PromoDTO;
import ensa.gestionnotes.projet_jee.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")

public class AdminController {
    @Autowired
    private IProfesseurService professeurService;
    @Autowired
    private IFiliiereService filiiereService;
    @Autowired
    private IPromoService promoService;
    @Autowired
    private IEtudaintService etudaintService;
    private ISemestreService semestreService;
    @PostMapping("/add-professeur")
    public ResponseEntity<Professeur> saveProfesseur(@RequestBody Professeur p) {
        try {
            Professeur savedProfesseur = professeurService.saveProfesseur(p);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedProfesseur);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @PostMapping("/filiere")

    public ResponseEntity<?> saveFiliere(@RequestBody Filiere f) {
        try {
            System.out.println("Filiere reçue : " + f.toString());
            Filiere savedFiliere =filiiereService.saveFiliere(f);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedFiliere);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de l'ajout du FILIERE : " + e.getMessage());
        }
    }

    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "Bienvenue dans le tableau de bord admin";
    }


    @GetMapping("/filiere")
    public List<Filiere> getAllFilieres() {
        return filiiereService.getFilieres();
    }


    @DeleteMapping("/filiere/{id}")
    public ResponseEntity<String> deleteFiliere(@PathVariable Long id) {
        try {
            boolean exists = filiiereService.existsById(id); // Vérifier si la filière existe
            if (!exists) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filière non trouvée");
            }

            filiiereService.delete(id); // Supprimer la filière
            return ResponseEntity.ok("Filière supprimée avec succès");
        } catch (Exception e) {
            // Gérer les erreurs inattendues
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur interne du serveur");
        }
    }

    @PutMapping("/filiere/{id}")
    public ResponseEntity<?> updateFiliere(@PathVariable Long id, @RequestBody Filiere filiere) {
        Filiere filiere1 = filiiereService.getFiliereById(id);
        if(filiere1!=null){

             return  ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED).body(filiiereService.update(filiere));
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur interne du serveur");
    }


    @GetMapping("/promos")
    public ResponseEntity<Map<String, List<PromoDTO>>> getAllPromos() {
        List<PromoDTO> promos = promoService.getAllPromos();
        return ResponseEntity.ok(Map.of("promos", promos));
    }
    @PostMapping("/promos")
    public ResponseEntity<?> createPromo(@RequestBody PromoDTO promo) {
        return ResponseEntity.ok(promoService.createPromo(promo));
    }

    @DeleteMapping("/promos/{id}")
    public void deletePromo(@PathVariable Long id) {
         promoService.deletePromo(id);
    }

    //Gestion etudient :

    @GetMapping("/etudiants")
    public ResponseEntity<List<EtudiantDtoReponse>> getAllEtudiants() {
        return ResponseEntity.ok(etudaintService.getAllEtudiants());
    }

    @PostMapping("/etudiants")
    public  ResponseEntity<Void>  addEtudiant(@RequestBody EtudiantDTO etudiantDTO) {
        etudaintService.addEtudiant(etudiantDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/etudiants/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Long id) {
         etudaintService.deleteEtudiant(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/etudiants/filieres")
    public ResponseEntity<List<Filiere>> getAllFiliere() {
        return ResponseEntity.ok(filiiereService.getFilieres());
    }

    @GetMapping("/etudiants/promos")
    public ResponseEntity<List<Promo>> getLastThreePromos() {
        return ResponseEntity.ok(promoService.findLastPromos());
    }

    @GetMapping("/etudiants/promos/{promoId}/semestres")
    public ResponseEntity<List<Semestre>> getSemestresByPromo(@PathVariable Long promoId) {
        return ResponseEntity.ok( semestreService.findByPromoId(promoId));
    }

}
