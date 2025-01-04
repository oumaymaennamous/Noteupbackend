package ensa.gestionnotes.projet_jee.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
public class Semestre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_semestre;
    private String semestre;
    private String annee;
    @OneToMany(mappedBy ="semestre" ,cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<SemestreEtudiant> etudiants;

    @ManyToOne
    @JoinColumn(name = "Id_promo", referencedColumnName = "idPromo")
    private Promo promo;

    @OneToMany(mappedBy ="semestre" ,cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Module> Modules;

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public void setEtudiants(List<SemestreEtudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public void setPromo(Promo promo) {
        this.promo = promo;
    }

    public void setModules(List<Module> modules) {
        Modules = modules;
    }

    public void setId_semestre(long id_semestre) {
        this.id_semestre = id_semestre;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getAnnee() {
        return annee;
    }

    public Promo getPromo() {
        return promo;
    }

    public List<SemestreEtudiant> getEtudiants() {
        return etudiants;
    }

    public List<Module> getModules() {
        return Modules;
    }

    public long getId_semestre() {
        return id_semestre;
    }
}
