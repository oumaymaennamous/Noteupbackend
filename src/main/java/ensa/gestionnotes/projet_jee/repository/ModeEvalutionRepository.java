package ensa.gestionnotes.projet_jee.repository;

import ensa.gestionnotes.projet_jee.Entity.Mode_Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModeEvalutionRepository extends JpaRepository<Mode_Evaluation,Long> {


    @Query("SELECT me FROM Mode_Evaluation me " +
            "JOIN me.elementModule em " +
            "JOIN em.module m " +
            "JOIN m.semestre s " +
            "JOIN s.etudiants se " +
            "JOIN se.etudiant e " +
            "WHERE e.CodeEtudiant = :idEtudiant " +
            "AND em.codeElementModule = :idElementModule")
    List<Mode_Evaluation> findModeEvaluationsByEtudiantAndElementModule(
            @Param("idEtudiant") Long idEtudiant,
            @Param("idElementModule") Long idElementModule
    );

    @Query("SELECT me FROM Mode_Evaluation me " +
            "JOIN me.elementModule em " +
            "WHERE em.codeElementModule = :codeElementModule")
    List<Mode_Evaluation> findByElementModule(@Param("codeElementModule") Long codeElementModule);


}
