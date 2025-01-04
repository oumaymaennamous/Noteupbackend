package ensa.gestionnotes.projet_jee.dto;

public class EtudiantDtoReponse {

    private String nom;
    private String prenom;
    private String cin;
    private String cne;
    private String filiere;
    private String semestre;
    private String annees ;

    public EtudiantDtoReponse(String nom , String prenom, String cin, String cne, String filiere, String semestre, String annees) {
        this.nom = nom;

        this.prenom = prenom;
        this.cin = cin;
        this.cne = cne;
        this.filiere = filiere;
        this.semestre = semestre;
        this.annees = annees;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCin() {
        return cin;
    }

    public String getFiliere() {
        return filiere;
    }

    public String getCne() {
        return cne;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getAnnees() {
        return annees;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setAnnees(String annees) {
        this.annees = annees;
    }
}
