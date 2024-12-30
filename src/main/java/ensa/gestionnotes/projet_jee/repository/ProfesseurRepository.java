package ensa.gestionnotes.projet_jee.repository;

import ensa.gestionnotes.projet_jee.Entity.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProfesseurRepository extends JpaRepository<Professeur,Long> {

    public Optional<Professeur> findByCIN(String cin);
}
