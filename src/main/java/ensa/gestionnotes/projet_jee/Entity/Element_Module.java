package ensa.gestionnotes.projet_jee.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="ElementModule")
@NoArgsConstructor @AllArgsConstructor
public class Element_Module implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long codeElementModule;
    @Column(nullable = false)
    private String nameElementModule;
    private double Coefficient;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "professeur_id", referencedColumnName = "id")
    private Professeur professeur;

    @ManyToOne
    @JoinColumn(name = "module_id", referencedColumnName = "CodeModule")
    private Module module;

    @OneToMany(mappedBy = "elementModule",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Mode_Evaluation> modeEvaluations ;

    @OneToMany(mappedBy = "elementModule",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Evaluation> Evaluations ;

    public void setCodeElementModule(long codeElementModule) {
        this.codeElementModule = codeElementModule;
    }

    public void setNameElementModule(String nameElementModule) {
        this.nameElementModule = nameElementModule;
    }

    public void setCoefficient(double coefficient) {
        Coefficient = coefficient;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public void setModeEvaluations(List<Mode_Evaluation> modeEvaluations) {
        this.modeEvaluations = modeEvaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        Evaluations = evaluations;
    }

    public long getCodeElementModule() {
        return codeElementModule;
    }

    public String getNameElementModule() {
        return nameElementModule;
    }

    public double getCoefficient() {
        return Coefficient;
    }

    public boolean isActive() {
        return active;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public Module getModule() {
        return module;
    }

    public List<Mode_Evaluation> getModeEvaluations() {
        return modeEvaluations;
    }

    public List<Evaluation> getEvaluations() {
        return Evaluations;
    }
}
