package ensa.gestionnotes.projet_jee.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Promo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPromo;
    private String namePromo;

    @OneToMany(mappedBy ="promo" ,cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Semestre> semestres;

    public String getNamePromo() {
        return namePromo;
    }

    public List<Semestre> getSemestres() {
        return semestres;
    }

    public long getIdPromo() {
        return idPromo;
    }

    public void setNamePromo(String namePromo) {
        this.namePromo = namePromo;
    }

    public void setSemestres(List<Semestre> semestres) {
        this.semestres = semestres;
    }

    public void setIdPromo(long idPromo) {
        this.idPromo = idPromo;
    }
}
