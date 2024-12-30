package ensa.gestionnotes.projet_jee.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long CodeEtudiant;
    private String nom;
    private String prenom;
    @Column(unique = true)
    private String CNE;
    @Column(unique = true)
    private String CIN;

    @OneToMany(mappedBy ="etudiant" ,cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Evaluation> Evaluations;

    @ManyToOne
    @JoinColumn(name = "Id_filiere", referencedColumnName = "CodeFiliere")
    private Filiere filiere;

    @OneToMany(mappedBy ="etudiant" ,cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<SemestreEtudiant> semestres;

    @OneToMany(mappedBy ="etudiant" ,cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Releve_De_Notes> releveDeNotes;

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCodeEtudiant(long codeEtudiant) {
        CodeEtudiant = codeEtudiant;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCNE(String CNE) {
        this.CNE = CNE;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        Evaluations = evaluations;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public void setSemestres(List<SemestreEtudiant> semestres) {
        this.semestres = semestres;
    }

    public void setReleveDeNotes(List<Releve_De_Notes> releveDeNotes) {
        this.releveDeNotes = releveDeNotes;
    }

    public long getCodeEtudiant() {
        return CodeEtudiant;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCNE() {
        return CNE;
    }

    public String getCIN() {
        return CIN;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public List<Evaluation> getEvaluations() {
        return Evaluations;
    }

    public List<SemestreEtudiant> getSemestres() {
        return semestres;
    }

    public List<Releve_De_Notes> getReleveDeNotes() {
        return releveDeNotes;
    }
}
