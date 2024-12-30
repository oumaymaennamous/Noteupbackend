package ensa.gestionnotes.projet_jee.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Releve_De_Notes {
   @Id
   private long id;
   private double note;
   private String resultat;
   private String Mention;

   @ManyToOne
   @JoinColumn(name = "Id_etudiant", referencedColumnName = "CodeEtudiant")
   private Etudiant etudiant;
   @ManyToOne
   @JoinColumn(name = "module_id", referencedColumnName = "CodeModule")
   private Module module;
}
