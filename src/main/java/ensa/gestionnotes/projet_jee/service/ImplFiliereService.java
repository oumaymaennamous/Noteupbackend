package ensa.gestionnotes.projet_jee.service;

import ensa.gestionnotes.projet_jee.Entity.Filiere;
import ensa.gestionnotes.projet_jee.repository.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplFiliereService implements IFiliiereService{
    @Autowired
    FiliereRepository filiereRepository;
    @Override
    public Filiere saveFiliere(Filiere filiere) {
        return filiereRepository.save(filiere);
    }

    @Override
    public void delete(long idFiliere) {
        filiereRepository.deleteById(idFiliere);
    }

    @Override
    public Filiere update(Filiere filiere) {

        return filiereRepository.save(filiere);
    }

    @Override
    public List<Filiere> getFilieres() {
        return filiereRepository.findAll();
    }

    @Override
    public boolean existsById(long idFiliere) {

        return filiereRepository.existsById(idFiliere);
    }

    @Override
    public Filiere getFiliereById(long idFiliere) {
        return filiereRepository.findById(idFiliere).get();
    }
}
