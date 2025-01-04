package ensa.gestionnotes.projet_jee.dto;

public class ModuleDTO {
    private Long codeModule;
    private String nameModule;
    private String filiereName;
    private String semestreName;
    private String annee;

    public String getNameModule() {
        return nameModule;
    }

    public Long getCodeModule() {
        return codeModule;
    }

    public String getFiliereName() {
        return filiereName;
    }

    public String getSemestreName() {
        return semestreName;
    }

    public String getAnnee() {
        return annee;
    }

    public void setCodeModule(Long codeModule) {
        this.codeModule = codeModule;
    }

    public void setNameModule(String nameModule) {
        this.nameModule = nameModule;
    }

    public void setFiliereName(String filiereName) {
        this.filiereName = filiereName;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public void setSemestreName(String semestreName) {
        this.semestreName = semestreName;
    }

    public ModuleDTO(Long codeModule, String nameModule, String filiereName, String semestreName, String annee) {
        this.codeModule = codeModule;
        this.nameModule = nameModule;
        this.filiereName = filiereName;
        this.semestreName = semestreName;
        this.annee = annee;
    }

    public ModuleDTO() {
    }
}
