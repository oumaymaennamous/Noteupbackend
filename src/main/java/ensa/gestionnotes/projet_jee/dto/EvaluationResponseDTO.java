package ensa.gestionnotes.projet_jee.dto;

public class EvaluationResponseDTO {
    private Long id_evalution;
    private double note;
    private boolean absance;
    private Long codeEtudiant;
    private Long codeElementModule;
    private Long codeMode;

    public Long getId_evalution() {
        return id_evalution;
    }

    public double getNote() {
        return note;
    }

    public boolean isAbsance() {
        return absance;
    }

    public Long getCodeEtudiant() {
        return codeEtudiant;
    }

    public Long getCodeElementModule() {
        return codeElementModule;
    }

    public Long getCodeMode() {
        return codeMode;
    }

    public void setId_evalution(Long id_evalution) {
        this.id_evalution = id_evalution;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public void setAbsance(boolean absance) {
        this.absance = absance;
    }

    public void setCodeEtudiant(Long codeEtudiant) {
        this.codeEtudiant = codeEtudiant;
    }

    public void setCodeMode(Long codeMode) {
        this.codeMode = codeMode;
    }

    public void setCodeElementModule(Long codeElementModule) {
        this.codeElementModule = codeElementModule;
    }

    public EvaluationResponseDTO() {
    }
}