package org.example.gekobetv1.dtos;
import org.example.gekobetv1.entities.Season;

public class LigueDTO {
    private int id;
    private  String nameligue;
    private Season season;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameligue() {
        return nameligue;
    }

    public void setNameligue(String nameligue) {
        this.nameligue = nameligue;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}