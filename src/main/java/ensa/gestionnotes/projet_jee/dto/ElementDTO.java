package ensa.gestionnotes.projet_jee.dto;

import java.util.List;

public class ElementDTO {
      private long codeElementModule;
      private String   nameElementModule;
      private double coefficient;
      private boolean active;
      private List<ModeEvaluationDTO> evaluationModes;
      private String moduleName;
      private long codeModule;

    public long getCodeElementModule() {
        return codeElementModule;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public String getNameElementModule() {
        return nameElementModule;
    }

    public boolean isActive() {
        return active;
    }


    public String getModuleName() {
        return moduleName;
    }

    public void setCodeElementModule(long codeElementModule) {
        this.codeElementModule = codeElementModule;
    }

    public void setNameElementModule(String nameElementModule) {
        this.nameElementModule = nameElementModule;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public ElementDTO() {
    }

    public void setEvaluationModes(List<ModeEvaluationDTO> evaluationModes) {
        this.evaluationModes = evaluationModes;
    }

    public List<ModeEvaluationDTO> getEvaluationModes() {
        return evaluationModes;
    }

    public void setCodeModule(long codeModule) {
        this.codeModule = codeModule;
    }

    public long getCodeModule() {
        return codeModule;
    }
}
