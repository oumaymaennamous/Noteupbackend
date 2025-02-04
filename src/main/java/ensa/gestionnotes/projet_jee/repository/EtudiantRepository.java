package ensa.gestionnotes.projet_jee.repository;

import ensa.gestionnotes.projet_jee.Entity.Etudiant;
import ensa.gestionnotes.projet_jee.dto.EtudiantDtoReponse;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    @Query("SELECT new ensa.gestionnotes.projet_jee.dto.EtudiantDtoReponse(e.nom, e.prenom, e.CIN, e.CNE,m.filiere.NomFiliere,s.semestre, s.annee)"
            +"FROM Etudiant e " +
            "JOIN SemestreEtudiant se ON e.CodeEtudiant = se.etudiant.CodeEtudiant " +
            "JOIN Semestre s ON s.id_semestre = se.semestre.id_semestre " +
            "JOIN Module m ON m.semestre.id_semestre = s.id_semestre " +
            "JOIN Element_Module em ON em.module.CodeModule=m.CodeModule " +
            "WHERE em.codeElementModule = :codeElementModule")
    List<EtudiantDtoReponse> findEtudiantsByElementModule(@Param("codeElementModule") Long codeElementModule);


    @Query("SELECT e, ev " +
            "FROM Etudiant e " +
            "JOIN SemestreEtudiant se ON e.CodeEtudiant = se.etudiant.CodeEtudiant " +
            "JOIN Semestre s ON s.id_semestre = se.semestre.id_semestre " +
            "JOIN Module m ON m.semestre.id_semestre = s.id_semestre " +
            "JOIN Element_Module em ON em.module.CodeModule = m.CodeModule " +
            "LEFT JOIN Evaluation ev ON ev.etudiant.CodeEtudiant = e.CodeEtudiant " +
            "WHERE em.codeElementModule = :codeElementModule " +
            "AND ev.mode_evaluation.codeMode = :idModeEvaluation And e.filiere.CodeFiliere=m.filiere.CodeFiliere")
    List<Object[]> findEtudiantsAndEvaluationsByElementModuleAndMode(
            @Param("codeElementModule") Long codeElementModule,
            @Param("idModeEvaluation") Long idModeEvaluation);

    @Query("SELECT new ensa.gestionnotes.projet_jee.dto.EtudiantDtoReponse(" +
            "e.nom, e.prenom, e.CIN, e.CNE, f.NomFiliere,s.semestre, s.annee) " +
            "FROM SemestreEtudiant se " +
            "JOIN se.etudiant e " +
            "JOIN se.semestre s " +
            "JOIN e.filiere f")
    List<EtudiantDtoReponse> findAllEtudiantDto();
    @Modifying
    @Transactional
    @Query("DELETE  FROM Etudiant e WHERE e.CIN= :cin")
    void deleteEtudiandByCIN(@Param("cin") String cin);
    @Query("SELECT new ensa.gestionnotes.projet_jee.dto.EtudiantDtoReponse(" +
            "e.nom, e.prenom, e.CIN, e.CNE, f.NomFiliere,s.semestre, s.annee) "+
            "FROM SemestreEtudiant se " +
            "JOIN se.etudiant e " +
            "JOIN se.semestre s " +
            "JOIN e.filiere f WHERE s.annee= :annee and s.semestre= :semestre")
    List<EtudiantDtoReponse> getEtudaintBySemestreAndAnnee(@Param("semestre") String semestre, @Param("annee") String annee);




}
