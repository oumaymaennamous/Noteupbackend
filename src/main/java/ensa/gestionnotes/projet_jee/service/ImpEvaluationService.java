package ensa.gestionnotes.projet_jee.service;

import ensa.gestionnotes.projet_jee.Entity.Evaluation;
import ensa.gestionnotes.projet_jee.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImpEvaluationService  implements IEvaluationService{
    @Autowired
    private EvaluationRepository evaluationRepository;

    public List<Evaluation> getEvaluationsByMode(Long modeId) {
        return evaluationRepository.findEvaluationsByMode(modeId);
    }

    public void saveEvaluations(List<Evaluation> evaluations) {
        evaluationRepository.saveAll(evaluations);
    }
}
