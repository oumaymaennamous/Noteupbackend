package ensa.gestionnotes.projet_jee.dto;

import lombok.Data;


public class PromoDTO {
    private Long idPromo;
    private String namePromo;

    public Long getIdPromo() {
        return idPromo;
    }

    public String getNamePromo() {
        return namePromo;
    }

    public void setNamePromo(String namePromo) {
        this.namePromo = namePromo;
    }

    public void setIdPromo(Long idPromo) {
        this.idPromo = idPromo;
    }
}
