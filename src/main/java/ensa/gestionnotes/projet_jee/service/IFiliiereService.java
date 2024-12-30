package ensa.gestionnotes.projet_jee.service;

import ensa.gestionnotes.projet_jee.Entity.Filiere;

import java.util.List;

public interface IFiliiereService {
    Filiere saveFiliere(Filiere filiere);
    void delete(long idFiliere);
    Filiere update(Filiere filiere);
    List<Filiere> getFilieres();
    boolean existsById(long idFiliere);
    Filiere getFiliereById(long idFiliere);


}
