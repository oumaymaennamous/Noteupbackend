package ensa.gestionnotes.projet_jee.service;

import ensa.gestionnotes.projet_jee.Entity.Evaluation;

import java.util.List;

public interface IEvaluationService {
    public List<Evaluation> getEvaluationsByMode(Long modeId);
    public void saveEvaluations(List<Evaluation> evaluations);
}
