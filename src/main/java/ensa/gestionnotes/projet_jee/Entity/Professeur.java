package ensa.gestionnotes.projet_jee.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="Professeur")
@NoArgsConstructor
@AllArgsConstructor

public class Professeur  implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    private String  spécialité;
    @Column(unique = true,nullable = false)
    private String CIN;

    @OneToMany(mappedBy = "professeur" ,cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Element_Module> elementModules;

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public void setElementModules(List<Element_Module> elementModules) {
        this.elementModules = elementModules;
    }

    public void setSpécialité(String spécialité) {
        this.spécialité = spécialité;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSpécialité() {
        return spécialité;
    }

    public String getCIN() {
        return CIN;
    }

    public List<Element_Module> getElementModules() {
        return elementModules;
    }

    public long getId() {
        return id;
    }
}
