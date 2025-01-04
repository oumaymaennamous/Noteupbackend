package ensa.gestionnotes.projet_jee.service;

import ensa.gestionnotes.projet_jee.Entity.Professeur;
import ensa.gestionnotes.projet_jee.dto.ProfesseurDTO;
import ensa.gestionnotes.projet_jee.dto.ProfessorDTO;

import java.util.List;
import java.util.Optional;

public interface IProfesseurService {
    public List<ProfesseurDTO> getAllProfesseurs();
    public ProfesseurDTO getProfesseurById(Long id);
    public ProfesseurDTO addProfesseur(ProfesseurDTO professeur);
    public ProfesseurDTO updateProfesseur(Long id, ProfesseurDTO professeurDetails);
    public void deleteProfesseur(Long id);
    public ProfesseurDTO findByCin(String cin);
    public List<ProfessorDTO> getAllProfessor();

}
