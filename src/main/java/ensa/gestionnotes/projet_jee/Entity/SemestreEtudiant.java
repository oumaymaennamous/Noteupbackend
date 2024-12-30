package ensa.gestionnotes.projet_jee.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity   @NoArgsConstructor @AllArgsConstructor
public class SemestreEtudiant  implements Serializable {
    @Id
     private String id;
     private String Status; // encour /valide /non valide
     @ManyToOne
     @JoinColumn(name = "Id_etudiant", referencedColumnName = "CodeEtudiant")
     private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "Id_semestre", referencedColumnName = "id_semestre")
    private Semestre semestre;

    public void setStatus(String status) {
        Status = status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }
}
