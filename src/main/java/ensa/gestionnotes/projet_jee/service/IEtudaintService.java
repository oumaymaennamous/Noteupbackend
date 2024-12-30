package ensa.gestionnotes.projet_jee.service;

import ensa.gestionnotes.projet_jee.Entity.Etudiant;
import ensa.gestionnotes.projet_jee.dto.EtudiantDTO;
import ensa.gestionnotes.projet_jee.dto.EtudiantDtoReponse;

import java.util.List;

public interface IEtudaintService {
    public List<EtudiantDtoReponse> getAllEtudiants();
    public  void  addEtudiant(EtudiantDTO etudiantDTO);
    public void deleteEtudiant(Long id);

}
