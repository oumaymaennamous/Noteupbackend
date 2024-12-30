package ensa.gestionnotes.projet_jee.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
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


}
