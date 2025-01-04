package ensa.gestionnotes.projet_jee.dto;

public class ProfessorDTO {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProfessorDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProfessorDTO() {
    }
}
