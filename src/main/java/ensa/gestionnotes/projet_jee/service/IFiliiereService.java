package ensa.gestionnotes.projet_jee.service;

import ensa.gestionnotes.projet_jee.Entity.Filiere;
import ensa.gestionnotes.projet_jee.dto.FiliereDTO;

import java.util.List;

public interface IFiliiereService {
    Filiere saveFiliere(Filiere filiere);
    void delete(long idFiliere);
    Filiere update(Filiere filiere);
    List<FiliereDTO> getFilieres();
    boolean existsById(long idFiliere);
    Filiere getFiliereById(long idFiliere);


}
