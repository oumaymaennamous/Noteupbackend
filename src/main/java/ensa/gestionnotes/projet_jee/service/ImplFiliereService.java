package ensa.gestionnotes.projet_jee.service;

import ensa.gestionnotes.projet_jee.Entity.Filiere;
import ensa.gestionnotes.projet_jee.Entity.Module;
import ensa.gestionnotes.projet_jee.dto.FiliereDTO;
import ensa.gestionnotes.projet_jee.dto.ModuleDTO;
import ensa.gestionnotes.projet_jee.repository.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<FiliereDTO> getFilieres() {
        List<Filiere> filieres=filiereRepository.findAll();
        return filieres.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public boolean existsById(long idFiliere) {

        return filiereRepository.existsById(idFiliere);
    }

    @Override
    public Filiere getFiliereById(long idFiliere) {
        return filiereRepository.findById(idFiliere).get();
    }
    private FiliereDTO convertToDTO(Filiere filiere) {
         FiliereDTO dto = new FiliereDTO();
         dto.setCodeFiliere(filiere.getCodeFiliere());
         dto.setNomFiliere(filiere.getNomFiliere());
        return dto;
    }

}
