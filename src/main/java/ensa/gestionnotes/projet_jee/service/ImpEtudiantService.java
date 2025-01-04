package ensa.gestionnotes.projet_jee.service;

import ensa.gestionnotes.projet_jee.Entity.*;
import ensa.gestionnotes.projet_jee.dto.EtudiantDTO;
import ensa.gestionnotes.projet_jee.dto.EtudiantDtoReponse;
import ensa.gestionnotes.projet_jee.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public void  addEtudiant(EtudiantDtoReponse etudiantDTO) {
        Etudiant etudiant = new Etudiant();
        etudiant.setNom(etudiantDTO.getNom());
        etudiant.setPrenom(etudiantDTO.getPrenom());
        etudiant.setCIN(etudiantDTO.getCin());
        etudiant.setCNE(etudiantDTO.getCne());

        Filiere filiere = filiereRepository.findByNomFiliere(etudiantDTO.getFiliere());
        etudiant.setFiliere(filiere);

        Semestre S=semestreRepository.findByNomAndAnnee(etudiantDTO.getSemestre(),etudiantDTO.getAnnees()).orElseThrow(() -> new RuntimeException("Semestre non trouvé"));;

            Etudiant savedEtudiant = etudiantRepository.save(etudiant);
            SemestreEtudiant SE=new SemestreEtudiant();
            SE.setEtudiant(savedEtudiant);
            SE.setSemestre(S);
            SE.setStatus("en cours");

            etudiantSemestreRepository.save(SE);




    }

    public void deleteEtudiant(String cin) {
        etudiantRepository.deleteEtudiandByCIN(cin);
    }


}
