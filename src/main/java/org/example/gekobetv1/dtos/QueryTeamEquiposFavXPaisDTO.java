package org.example.gekobetv1.dtos;

public class QueryTeamEquiposFavXPaisDTO {
    private int id;
    private int id_ligue;
    private String nameteam;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_ligue() {
        return id_ligue;
    }

    public void setId_ligue(int id_ligue) {
        this.id_ligue = id_ligue;
    }

    public String getNameteam() {
        return nameteam;
    }

    public void setNameteam(String nameteam) {
        this.nameteam = nameteam;
    }
}
