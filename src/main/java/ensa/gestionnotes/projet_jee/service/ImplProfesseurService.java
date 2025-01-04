package ensa.gestionnotes.projet_jee.service;

import ensa.gestionnotes.projet_jee.Entity.Module;
import ensa.gestionnotes.projet_jee.Entity.Professeur;
import ensa.gestionnotes.projet_jee.dto.ModuleDTO;
import ensa.gestionnotes.projet_jee.dto.ProfesseurDTO;
import ensa.gestionnotes.projet_jee.dto.ProfessorDTO;
import ensa.gestionnotes.projet_jee.repository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImplProfesseurService implements IProfesseurService {

  @Autowired
  private  ProfesseurRepository professeurRepository;

    @Override
    public List<ProfesseurDTO> getAllProfesseurs() {
        List<Professeur> professeurs=professeurRepository.findAll();
        return  professeurs.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ProfesseurDTO getProfesseurById(Long id) {
        Professeur professeur=professeurRepository.findById(id).orElse(null);
        return convertToDTO(professeur);
    }

    @Override
    public ProfesseurDTO addProfesseur(ProfesseurDTO professeur) {
        Professeur professeur1= new Professeur();
        professeur1.setNom(professeur.getNom());
        professeur1.setPrenom(professeur.getPrenom());
        professeur1.setSpécialité(professeur.getSpecialite());
        professeur1.setCIN(professeur.getCin());
        professeurRepository.save(professeur1);

        return convertToDTO(professeur1);
    }

    @Override
    public  ProfesseurDTO updateProfesseur(Long id, ProfesseurDTO professeurDetails) {
        Optional<Professeur> professeur = professeurRepository.findById(id);
        if (professeur.isPresent()) {
            Professeur existingProfesseur = professeur.get();
            existingProfesseur.setNom(professeurDetails.getNom());
            existingProfesseur.setPrenom(professeurDetails.getPrenom());
            existingProfesseur.setSpécialité(professeurDetails.getSpecialite());
            existingProfesseur.setCIN(professeurDetails.getCin());
            professeurRepository.save(existingProfesseur);
            return convertToDTO(existingProfesseur)  ;
        }
        return null;
    }


    @Override
    public void deleteProfesseur(Long id) {
        professeurRepository.deleteById(id);
    }


    @Override
    public ProfesseurDTO findByCin(String cin) {
        Professeur professeur =professeurRepository.findByCIN(cin).get();
        return convertToDTO(professeur);
    }

    @Override
    public List<ProfessorDTO> getAllProfessor() {
        List<Professeur> professeurs=professeurRepository.findAll();
        return professeurs.stream().map(this::convertToProfessor).collect(Collectors.toList());
    }

    public ProfesseurDTO convertToDTO(Professeur professeur) {
        ProfesseurDTO dto=new ProfesseurDTO();
        dto.setId(professeur.getId());
        dto.setNom(professeur.getNom());
        dto.setPrenom(professeur.getPrenom());
        dto.setSpecialite(professeur.getSpécialité());
        dto.setCin(professeur.getCIN());
        return dto;
    }
    public ProfessorDTO convertToProfessor(Professeur professeur) {
        ProfessorDTO dto=new ProfessorDTO();
        dto.setId(professeur.getId());
        dto.setName(professeur.getNom());
        return dto;
    }
}
