package ensa.gestionnotes.projet_jee.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="ElementModule")
@Data @NoArgsConstructor @AllArgsConstructor
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


}
