package ensa.gestionnotes.projet_jee.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
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
}
