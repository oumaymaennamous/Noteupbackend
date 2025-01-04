package ensa.gestionnotes.projet_jee.repository;

import ensa.gestionnotes.projet_jee.Entity.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FiliereRepository extends JpaRepository<Filiere,Long>{
    @Query("SELECT F FROM Filiere F WHERE F.NomFiliere= :NomFiliere")
    Filiere findByNomFiliere(@Param("NomFiliere") String NomFiliere);

}