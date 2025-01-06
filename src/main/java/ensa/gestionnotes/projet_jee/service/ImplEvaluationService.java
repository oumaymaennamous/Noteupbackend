package ensa.gestionnotes.projet_jee.service;

import ensa.gestionnotes.projet_jee.Entity.Evaluation;
import ensa.gestionnotes.projet_jee.dto.EvaluationResponseDTO;
import ensa.gestionnotes.projet_jee.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImplEvaluationService implements IEvaluation {
    @Autowired
    private EvaluationRepository evaluationRepository;
    @Override
    public List<EvaluationResponseDTO> getEvaluations(Long elementId, Long modeId) {
        return evaluationRepository.findEvaluationsBycodeElementAndMode(elementId,modeId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EvaluationResponseDTO convertToDTO(Evaluation evaluation) {
        EvaluationResponseDTO dto=new EvaluationResponseDTO();
         dto.setId_evalution(evaluation.getId_evalution());
         dto.setCodeElementModule(evaluation.getElementModule().getCodeElementModule());
         dto.setCodeMode(evaluation.getMode_evaluation().getCodeMode());
         dto.setCodeEtudiant(evaluation.getEtudiant().getCodeEtudiant());
         dto.setNote(evaluation.getNote());
         dto.setAbsance(evaluation.isAbsance());
        return null;
    }


}
