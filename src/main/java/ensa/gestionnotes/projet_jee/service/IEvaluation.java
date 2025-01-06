package ensa.gestionnotes.projet_jee.service;

import ensa.gestionnotes.projet_jee.Entity.Evaluation;
import ensa.gestionnotes.projet_jee.dto.EvaluationResponseDTO;

import java.util.List;

public interface IEvaluation {
    public List<EvaluationResponseDTO> getEvaluations(Long elementId, Long modeId);
    public EvaluationResponseDTO convertToDTO(Evaluation evaluation);
}
