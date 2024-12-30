package ensa.gestionnotes.projet_jee.dto;

import lombok.Data;


public class EtudiantDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String cin;
    private String cne;
    private String filiere;
    private String promo;
    private String semestre;

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCin() {
        return cin;
    }

    public String getCne() {
        return cne;
    }

    public String getFiliere() {
        return filiere;
    }

    public String getPromo() {
        return promo;
    }

    public String getSemestre() {
        return semestre;
    }

    public Long getId() {
        return id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public void setPromo(String promo) {
        this.promo = promo;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setId(Long id) {
        this.id = id;
    }
}