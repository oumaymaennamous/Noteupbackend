package ensa.gestionnotes.projet_jee.dto;

public class ModeEvaluationDTO {
    private long codeMode;
    private String type;
    private double coefficient;

    public long getCodeMode() {
        return codeMode;
    }

    public String getType() {
        return type;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCodeMode(long codeMode) {
        this.codeMode = codeMode;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public ModeEvaluationDTO() {
    }

    public ModeEvaluationDTO(long codeMode, String type, double coefficient) {
        this.codeMode = codeMode;
        this.type = type;
        this.coefficient = coefficient;
    }
}
