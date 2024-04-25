package org.example.gekobetv1.dtos;

public class LigueDTO {
    private int id;
    private  String nameligue;
    private SeasonDTO season;

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

    public SeasonDTO getSeason() {
        return season;
    }

    public void setSeason(SeasonDTO season) {
        this.season = season;
    }
}