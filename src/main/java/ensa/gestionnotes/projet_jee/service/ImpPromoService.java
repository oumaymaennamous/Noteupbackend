package ensa.gestionnotes.projet_jee.service;

import ensa.gestionnotes.projet_jee.Entity.Promo;
import ensa.gestionnotes.projet_jee.Entity.Semestre;
import ensa.gestionnotes.projet_jee.dto.PromoDTO;
import ensa.gestionnotes.projet_jee.repository.PromoRepository;
import ensa.gestionnotes.projet_jee.repository.SemestreRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImpPromoService implements  IPromoService{

    @Autowired
    private PromoRepository promoRepository;

    @Autowired
    private SemestreRepository semestreRepository;
    @Override
    public List<PromoDTO> getAllPromos() {
        return promoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    @Override
    public PromoDTO createPromo(PromoDTO promoDTO) {
        // Sauvegarder la promo
        Promo promo = new Promo();
        promo.setNamePromo(promoDTO.getNamePromo());
        promo = promoRepository.save(promo);

        // Obtenir l'année actuelle
        int currentYear = LocalDate.now().getYear();
        String[] AnneUniver={currentYear+"/"+(currentYear+1),currentYear+"/"+(currentYear+1),currentYear+1+"/"+(currentYear+2)
        ,currentYear+1+"/"+(currentYear+2),currentYear+2+"/"+(currentYear+3),currentYear+2+"/"+(currentYear+3)};
        // Créer 5 semestres pour la nouvelle promo
        for (int i = 1; i <= 5; i++) {
            Semestre semestre = new Semestre();
            semestre.setSemestre("S" + i);
            semestre.setAnnee( AnneUniver[i-1]);
            semestre.setPromo(promo);
            semestreRepository.save(semestre);
        }

        return convertToDTO(promo);
    }

    @Override
    public void deletePromo(long id) {
        // 1. Vérifier si la promotion existe
        Optional<Promo> optionalPromo = promoRepository.findById(id);
        if (!optionalPromo.isPresent()) {
            throw new EntityNotFoundException("La promotion avec l'ID " + id + " n'existe pas.");
        }

        // 2. Supprimer les semestres liés à la promotion
        Promo promo = optionalPromo.get();
        semestreRepository.deleteAll(promo.getSemestres());

        // 3. Supprimer la promotion
        promoRepository.delete(promo);
    }



    @Override
    public List<Promo> findLastPromos() {
        return promoRepository.findAll();
    }


    private PromoDTO convertToDTO(Promo promo) {
        PromoDTO dto = new PromoDTO();
        dto.setIdPromo(promo.getIdPromo());
        dto.setNamePromo(promo.getNamePromo());
        return dto;
    }

}
