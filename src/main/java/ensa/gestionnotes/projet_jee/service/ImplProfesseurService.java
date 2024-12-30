package ensa.gestionnotes.projet_jee.service;

import ensa.gestionnotes.projet_jee.Entity.Professeur;
import ensa.gestionnotes.projet_jee.repository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImplProfesseurService implements IProfesseurService {

  @Autowired
  private  ProfesseurRepository professeurRepository;
    @Override
    public Professeur saveProfesseur(Professeur professeur) {
        return  professeurRepository.save(professeur);
    }

    @Override
    public void deleteProfesseur(long idProfessuer) {
        professeurRepository.deleteById(idProfessuer);
    }

    @Override
    public Professeur getProfesseur(long idProfesseur) {
        return professeurRepository.findById(idProfesseur).get();
    }
    @Override
    public List<Professeur> updaeProfesseur(Professeur professeur) {
        professeurRepository.save(professeur);
        return professeurRepository.findAll();
    }
}
