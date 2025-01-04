package ensa.gestionnotes.projet_jee.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
  @AllArgsConstructor @NoArgsConstructor
public class Module implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long CodeModule;
    @Column(nullable = false)
    private String NameModule;



    @OneToMany(mappedBy = "module",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Element_Module> elementModuleList;


    @OneToMany(mappedBy ="module" ,cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Releve_De_Notes> releveDeNotes;

    @ManyToOne
    @JoinColumn(name = "Id_filiere", referencedColumnName = "CodeFiliere")
    private Filiere filiere;
    @ManyToOne
    @JoinColumn(name = "Id_semestre", referencedColumnName = "id_semestre")
    private Semestre semestre;

    public String getNameModule() {
        return NameModule;
    }

    public long getCodeModule() {
        return CodeModule;
    }

    public List<Element_Module> getElementModuleList() {
        return elementModuleList;
    }

    public List<Releve_De_Notes> getReleveDeNotes() {
        return releveDeNotes;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setCodeModule(long codeModule) {
        CodeModule = codeModule;
    }

    public void setNameModule(String nameModule) {
        NameModule = nameModule;
    }

    public void setElementModuleList(List<Element_Module> elementModuleList) {
        this.elementModuleList = elementModuleList;
    }

    public void setReleveDeNotes(List<Releve_De_Notes> releveDeNotes) {
        this.releveDeNotes = releveDeNotes;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }
}
