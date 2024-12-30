package ensa.gestionnotes.projet_jee.repository;

import ensa.gestionnotes.projet_jee.Entity.Element_Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ElementModuleRepository extends JpaRepository<Element_Module,Long> {
    Element_Module findById(long id);
    // Méthode pour lister les codes des modules par professeur
    @Query("select em from Element_Module em where em.professeur.id= :idProfesseur")
    List<Element_Module> listElementByProfesseur(long idProfesseur);

}
