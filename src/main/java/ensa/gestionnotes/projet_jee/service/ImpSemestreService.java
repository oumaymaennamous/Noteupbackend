package ensa.gestionnotes.projet_jee.service;

import ensa.gestionnotes.projet_jee.Entity.Semestre;
import ensa.gestionnotes.projet_jee.repository.SemestreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImpSemestreService implements  ISemestreService{
    @Autowired
    private SemestreRepository semestreRepository;
    @Override
    public List<Semestre> findByPromoId(long promoId) {
        return semestreRepository.findByPromoId(promoId);
    }

    @Override
    public List<String> getDistinctSemestres() {
        return semestreRepository.findDistinctSemestres();
    }

    @Override
    public List<String> getDistinctAnnees() {
        return semestreRepository.findDistinctAnnees();
    }
}
