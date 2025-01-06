package ensa.gestionnotes.projet_jee.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
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

    public long getId_evalution() {
        return id_evalution;
    }

    public double getNote() {
        return Note;
    }

    public double getNoteRatt() {
        return NoteRatt;
    }

    public boolean isAbsance() {
        return Absance;
    }

    public Element_Module getElementModule() {
        return elementModule;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public Mode_Evaluation getMode_evaluation() {
        return mode_evaluation;
    }

    public void setId_evalution(long id_evalution) {
        this.id_evalution = id_evalution;
    }

    public void setNote(double note) {
        Note = note;
    }

    public void setNoteRatt(double noteRatt) {
        NoteRatt = noteRatt;
    }

    public void setAbsance(boolean absance) {
        Absance = absance;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public void setMode_evaluation(Mode_Evaluation mode_evaluation) {
        this.mode_evaluation = mode_evaluation;
    }

    public void setElementModule(Element_Module elementModule) {
        this.elementModule = elementModule;
    }
}
