package ensa.gestionnotes.projet_jee.repository;

import ensa.gestionnotes.projet_jee.Entity.Element_Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ElementModuleRepository extends JpaRepository<Element_Module,Long> {
    Element_Module findById(long id);
    // Méthode pour lister les codes des modules par professeur
    @Query("select em from Element_Module em where em.professeur.id= :idProfesseur")
    List<Element_Module> listElementByProfesseur(long idProfesseur);
    @Query("SELECT em FROM Element_Module em WHERE em.module.CodeModule= :moduleId")
    List<Element_Module> findByModuleCodeModule(@Param("moduleId") Long moduleId);
    @Query("SELECT e FROM Element_Module e WHERE e.professeur.CIN= :cin")
    List<Element_Module> findElementByProfesseeur(@Param("cin") String cin);

}
