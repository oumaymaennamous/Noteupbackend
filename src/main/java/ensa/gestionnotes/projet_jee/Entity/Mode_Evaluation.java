package ensa.gestionnotes.projet_jee.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity  @AllArgsConstructor @NoArgsConstructor

public class Mode_Evaluation  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codeMode;
    @Column(nullable = false)
    private String Type;
    @Column
    private double Coefficient;
    @ManyToOne
    @JoinColumn(name = "IdElementModule", referencedColumnName = "codeElementModule")
    private Element_Module elementModule;

    @OneToMany(mappedBy ="mode_evaluation" ,cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Evaluation> evaluations;

    public long getCodeMode() {
        return codeMode;
    }

    public String getType() {
        return Type;
    }

    public double getCoefficient() {
        return Coefficient;
    }

    public Element_Module getElementModule() {
        return elementModule;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setCodeMode(long codeMode) {
        this.codeMode = codeMode;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setCoefficient(double coefficient) {
        Coefficient = coefficient;
    }

    public void setElementModule(Element_Module elementModule) {
        this.elementModule = elementModule;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }
}
