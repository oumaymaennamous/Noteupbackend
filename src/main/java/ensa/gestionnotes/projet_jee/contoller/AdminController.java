package ensa.gestionnotes.projet_jee.contoller;

import ensa.gestionnotes.projet_jee.Entity.Filiere;
import ensa.gestionnotes.projet_jee.Entity.Professeur;
import ensa.gestionnotes.projet_jee.Entity.Promo;
import ensa.gestionnotes.projet_jee.Entity.Semestre;
import ensa.gestionnotes.projet_jee.dto.*;
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
    @Autowired
    private ISemestreService semestreService;
    @Autowired
    private IModuleService moduleService;
    @Autowired
    private IElementModuleService elementModuleService;

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
    public List<FiliereDTO> getAllFilieres() {
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

    //----------------Gestion etudient-----------------------------------------

    @GetMapping("/etudiants")
    public ResponseEntity<List<EtudiantDtoReponse>> getAllEtudiants() {
        return ResponseEntity.ok(etudaintService.getAllEtudiants());
    }

    @PostMapping("/etudiants")
    public  ResponseEntity<?>  addEtudiant(@RequestBody EtudiantDtoReponse etudiantDTO) {
        etudaintService.addEtudiant(etudiantDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/etudiants/{cin}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable String cin) {
         etudaintService.deleteEtudiant(cin);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/etudiants/filieres")
    public ResponseEntity<List<FiliereDTO>> getAllFiliere() {
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
 // ------ Gestion module------------------------------//

    @GetMapping("/distinct-semestres")
    public List<String> getDistinctSemestres() {
        return semestreService.getDistinctSemestres();
    }

    @GetMapping("/distinct-annees")
    public List<String> getDistinctAnnees() {
        return semestreService.getDistinctAnnees();
    }

    @GetMapping("/modules")
    public List<ModuleDTO> getAllModules() {
        return moduleService.getAllModules();
    }
    @GetMapping("/modules/professors")
    public List<ProfessorDTO> getAllProfessors() {
        return professeurService.getAllProfessor();
    }

    @PostMapping("/modules")
    public ResponseEntity<?> addModule(@RequestBody ModuleDTO moduleDTO) {

        try{
           ModuleDTO moduleDTO1= moduleService.addModule(moduleDTO);
            return ResponseEntity.ok(moduleDTO1);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping("/modules/{id}")
    public ResponseEntity<ModuleDTO> getModule(@PathVariable Long id) {
        return ResponseEntity.ok(moduleService.getModuleById(id));
    }
    @GetMapping("/modules/{moduleId}/elements")
    public ResponseEntity<List<ElementModuleDTO>> getElementsByModule(@PathVariable Long moduleId) {
        return ResponseEntity.ok(elementModuleService.getElementsByModuleId(moduleId));
    }

    @PostMapping("/modules/{moduleId}/elements")
    public ResponseEntity<ElementModuleDTO> createElement(
            @PathVariable Long moduleId,
            @RequestBody ElementModuleDTO elementDTO) {
        return ResponseEntity.ok(elementModuleService.createElement(moduleId, elementDTO));
    }
    @DeleteMapping("/elements/{elementId}")
    public ResponseEntity<Void> deleteElement(@PathVariable Long elementId) {
        elementModuleService.deleteElement(elementId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/elements/{elementId}/evaluations")
    public ResponseEntity<ModeEvaluationDTO> addEvaluationMode(
            @PathVariable Long elementId,
            @RequestBody ModeEvaluationDTO evaluationDTO) {
        return ResponseEntity.ok(elementModuleService.addEvaluationMode(elementId, evaluationDTO));
    }

    @PatchMapping ("/evaluations/{evaluationId}")
    public ResponseEntity<ModeEvaluationDTO> updateEvaluationMode(
            @PathVariable Long evaluationId,
            @RequestBody ModeEvaluationDTO evaluationDTO) {
        return ResponseEntity.ok(elementModuleService.updateEvaluationMode(evaluationId, evaluationDTO));
    }

    @DeleteMapping("/evaluations/{evaluationId}")
    public ResponseEntity<Void> deleteEvaluationMode(@PathVariable Long evaluationId) {
        elementModuleService.deleteEvaluationMode(evaluationId);
        return ResponseEntity.noContent().build();
    }

    //---------------Gestion professuer-------------

    @GetMapping("/professeur")
    public ResponseEntity<List<ProfesseurDTO>> getAllProfesseurs() {
        List<ProfesseurDTO> professeurs = professeurService.getAllProfesseurs();
        return new ResponseEntity<>(professeurs, HttpStatus.OK);
    }

    @GetMapping("/professeur/{id}")
    public ResponseEntity<ProfesseurDTO> getProfesseurById(@PathVariable Long id) {
        ProfesseurDTO professeur = professeurService.getProfesseurById(id);
        if (professeur != null) {
            return new ResponseEntity<>(professeur, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/professeur-add")
    public ResponseEntity<ProfesseurDTO> addProfesseur(@RequestBody ProfesseurDTO professeur) {
        ProfesseurDTO newProfesseur = professeurService.addProfesseur(professeur);
        return new ResponseEntity<>(newProfesseur, HttpStatus.CREATED);
    }

    @PutMapping("/professeur-update/{id}")
    public ResponseEntity<ProfesseurDTO> updateProfesseur(@PathVariable Long id, @RequestBody ProfesseurDTO professeurDetails) {
        ProfesseurDTO updatedProfesseur = professeurService.updateProfesseur(id, professeurDetails);
        if (updatedProfesseur != null) {
            return new ResponseEntity<>(updatedProfesseur, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/professeur-delete/{id}")
    public ResponseEntity<Void> deleteProfesseur(@PathVariable Long id) {
        professeurService.deleteProfesseur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/professeur/cin/{cin}")
    public ResponseEntity<ProfesseurDTO> getProfesseurByCin(@PathVariable String cin) {
        ProfesseurDTO professeur = professeurService.findByCin(cin);
        if (professeur != null) {
            return new ResponseEntity<>(professeur, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
