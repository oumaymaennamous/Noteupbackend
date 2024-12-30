package ensa.gestionnotes.projet_jee.repository;

import ensa.gestionnotes.projet_jee.Entity.SemestreEtudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantSemestreRepository extends JpaRepository<SemestreEtudiant,Long> {
}
