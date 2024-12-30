package ensa.gestionnotes.projet_jee.service;

import ensa.gestionnotes.projet_jee.Entity.*;
import ensa.gestionnotes.projet_jee.dto.EtudiantDTO;
import ensa.gestionnotes.projet_jee.dto.EtudiantDtoReponse;
import ensa.gestionnotes.projet_jee.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImpEtudiantService implements IEtudaintService{

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private FiliereRepository filiereRepository;

    @Autowired
    private PromoRepository promoRepository;

    @Autowired
    private SemestreRepository semestreRepository;
    @Autowired
    private EtudiantSemestreRepository etudiantSemestreRepository;

    public List<EtudiantDtoReponse> getAllEtudiants() {
        return etudiantRepository.findAllEtudiantDto();
    }

    public void  addEtudiant(EtudiantDTO etudiantDTO) {
        Etudiant etudiant = new Etudiant();
        etudiant.setNom(etudiantDTO.getNom());
        etudiant.setPrenom(etudiantDTO.getPrenom());
        etudiant.setCIN(etudiantDTO.getCin());
        etudiant.setCNE(etudiantDTO.getCne());

        Filiere filiere = filiereRepository.findById(Long.parseLong(etudiantDTO.getFiliere()))
                .orElseThrow(() -> new RuntimeException("Filiere not found"));
        etudiant.setFiliere(filiere);
        Promo promo=promoRepository.findByNamePromo(etudiantDTO.getPromo());
        Semestre S1 =semestreRepository.findSemestreByPromoAndName(etudiantDTO.getSemestre(),promo.getIdPromo());

        SemestreEtudiant SE=new SemestreEtudiant();
        SE.setEtudiant(etudiant);
        SE.setSemestre(S1);
        SE.setStatus("en cours");

        etudiantSemestreRepository.save(SE);


        Etudiant savedEtudiant = etudiantRepository.save(etudiant);

    }

    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }


}
