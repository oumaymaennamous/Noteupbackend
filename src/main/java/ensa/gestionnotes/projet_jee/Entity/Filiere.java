package ensa.gestionnotes.projet_jee.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Filiere implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long CodeFiliere;
    @Column(unique = true,nullable = false)
    private String NomFiliere;


    @OneToMany(mappedBy = "filiere",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Etudiant> etudiants;

    @OneToMany(mappedBy = "filiere",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Module> modules;

    public String getNomFiliere() {
        return NomFiliere;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public List<Module> getModules() {
        return modules;
    }

    public long getCodeFiliere() {
        return CodeFiliere;
    }

    public void setNomFiliere(String nomFiliere) {
        NomFiliere = nomFiliere;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public void setCodeFiliere(long codeFiliere) {
        CodeFiliere = codeFiliere;
    }

    @Override
    public String toString() {
        return "Filiere{" +
                "NomFiliere='" + NomFiliere + '\'' +
                ", CodeFiliere=" + CodeFiliere +
                '}';
    }
}
