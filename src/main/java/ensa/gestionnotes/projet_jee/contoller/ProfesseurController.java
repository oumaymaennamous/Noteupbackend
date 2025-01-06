package ensa.gestionnotes.projet_jee.contoller;


import ensa.gestionnotes.projet_jee.Entity.Evaluation;
import ensa.gestionnotes.projet_jee.dto.ElementDTO;

import ensa.gestionnotes.projet_jee.dto.EtudiantDtoReponse;
import ensa.gestionnotes.projet_jee.dto.EvaluationResponseDTO;
import ensa.gestionnotes.projet_jee.service.IElementModuleService;
import ensa.gestionnotes.projet_jee.service.IEvaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/professeur")
public class ProfesseurController {
    @Autowired
    private IElementModuleService elementModuleService;
    @Autowired
    private IEvaluation evaluationService;
    // Affiche la liste des element de module d'un professeur //
    @GetMapping("/elements/{cin}")
    public ResponseEntity<List<ElementDTO>> getElementsByProfesseurCin(@PathVariable String cin) {
        List<ElementDTO> elements = elementModuleService.getElementModulesByProfessor(cin);
        return ResponseEntity.ok(elements);
    }
    @GetMapping("/element/{elementId}/etudiants")
    public ResponseEntity<List<EtudiantDtoReponse>> getEtudiantsByElementModule(@PathVariable Long elementId) {
        List<EtudiantDtoReponse> etudiants = elementModuleService.getEtudiantsByElement(elementId);
        return ResponseEntity.ok(etudiants);
    }
    // liste des evatution selon le mode et element

    @GetMapping("/evaluations/{elementId}/{modeId}")
    public ResponseEntity<List<EvaluationResponseDTO>> getEvaluations(
            @PathVariable Long elementId,
            @PathVariable Long modeId
    ) {
        List<EvaluationResponseDTO> evaluations = evaluationService.getEvaluations(elementId, modeId);
        return ResponseEntity.ok(evaluations);
    }

}
