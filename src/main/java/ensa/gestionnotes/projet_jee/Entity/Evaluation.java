package ensa.gestionnotes.projet_jee.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity  @Data
@AllArgsConstructor
@NoArgsConstructor
public class Evaluation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_evalution;
    private double Note;
    private double NoteRatt;
    private boolean Absance;
    @ManyToOne
    @JoinColumn(name = "IdElementModule", referencedColumnName = "codeElementModule")
    private Element_Module elementModule;
    @ManyToOne
    @JoinColumn(name = "Id_etudiant", referencedColumnName = "CodeEtudiant")
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "codeMode", referencedColumnName = "codeMode")
    private Mode_Evaluation mode_evaluation;

}
