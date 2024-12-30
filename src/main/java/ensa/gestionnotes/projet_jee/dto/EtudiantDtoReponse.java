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
}
