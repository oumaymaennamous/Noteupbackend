package ensa.gestionnotes.projet_jee.dto;

public class ProfesseurDTO {
   private long   id ;
   private String  nom ;
   private String  prenom;
   private String   specialite;
   private String   cin ;

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getCin() {
        return cin;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public ProfesseurDTO(long id, String nom, String prenom, String specialite, String cin) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.cin = cin;
    }

    public ProfesseurDTO() {
    }
}
