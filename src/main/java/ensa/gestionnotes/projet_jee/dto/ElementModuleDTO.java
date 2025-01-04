package ensa.gestionnotes.projet_jee.dto;

import java.util.List;

public class ElementModuleDTO {
    private long id;
    private String name;
    private double coefficient;
    private long professorId;
    private String professorName;
    private List<ModeEvaluationDTO> evaluationModes;
    private boolean active;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public void setProfessorId(long professorId) {
        this.professorId = professorId;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public void setEvaluationModes(List<ModeEvaluationDTO> evaluationModes) {
        this.evaluationModes = evaluationModes;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public long getProfessorId() {
        return professorId;
    }

    public String getProfessorName() {
        return professorName;
    }

    public List<ModeEvaluationDTO> getEvaluationModes() {
        return evaluationModes;
    }

    public boolean isActive() {
        return active;
    }

    public ElementModuleDTO() {
    }

    public ElementModuleDTO(long id, String name, double coefficient, long professorId, String professorName, List<ModeEvaluationDTO> evaluationModes, boolean active) {
        this.id = id;
        this.name = name;
        this.coefficient = coefficient;
        this.professorId = professorId;
        this.professorName = professorName;
        this.evaluationModes = evaluationModes;
        this.active = active;
    }
}
