package ensa.gestionnotes.projet_jee.dto;

import jakarta.persistence.Column;

public class FiliereDTO {
    private long CodeFiliere;

    private String NomFiliere;

    public long getCodeFiliere() {
        return CodeFiliere;
    }

    public String getNomFiliere() {
        return NomFiliere;
    }

    public void setCodeFiliere(long codeFiliere) {
        CodeFiliere = codeFiliere;
    }

    public void setNomFiliere(String nomFiliere) {
        NomFiliere = nomFiliere;
    }

    public FiliereDTO(long codeFiliere, String nomFiliere) {
        CodeFiliere = codeFiliere;
        NomFiliere = nomFiliere;
    }

    public FiliereDTO( ) {

    }
}
