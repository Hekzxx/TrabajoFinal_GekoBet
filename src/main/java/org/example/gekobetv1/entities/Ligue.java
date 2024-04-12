package org.example.gekobetv1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Ligue")
public class Ligue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nameligue",nullable = false,length = 40)
    private  String nameligue;

    @ManyToOne
    @JoinColumn(name = "idSeason")
    private Season season;

    public Ligue() {
    }

    public Ligue(int id, String nameligue, Season season) {
        this.id = id;
        this.nameligue = nameligue;
        this.season = season;
    }

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