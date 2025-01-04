package ensa.gestionnotes.projet_jee.service;

import ensa.gestionnotes.projet_jee.Entity.Semestre;

import java.util.List;

public interface ISemestreService {
    public List<Semestre> findByPromoId(long promoId);
    List<String> getDistinctSemestres();
    List<String> getDistinctAnnees();
}
