package ensa.gestionnotes.projet_jee.service;

import ensa.gestionnotes.projet_jee.Entity.Professeur;

import java.util.List;

public interface IProfesseurService {
    Professeur saveProfesseur(Professeur professeur);
    void deleteProfesseur(long idProfessuer);
    Professeur getProfesseur(long idProfesseur);
    List<Professeur> updaeProfesseur(Professeur professeur);
}
