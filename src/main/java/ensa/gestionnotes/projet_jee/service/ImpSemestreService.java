package ensa.gestionnotes.projet_jee.service;

import ensa.gestionnotes.projet_jee.Entity.Semestre;
import ensa.gestionnotes.projet_jee.repository.SemestreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImpSemestreService implements  ISemestreService{
    private SemestreRepository semestreRepository;
    @Override
    public List<Semestre> findByPromoId(long promoId) {
        return semestreRepository.findByPromoId(promoId);
    }
}
