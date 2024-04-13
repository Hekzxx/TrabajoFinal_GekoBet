package org.example.gekobetv1.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "Team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTeam;
    @Column(name = "nameteam", nullable = false, length = 40)
    private String nameteam;

    @ManyToOne
    @JoinColumn(name = "idLigue")
    private Ligue ligue;
    @ManyToOne
    @JoinColumn(name = "idMatch")
    private Match match;

    public Team() {
    }

    public Team(int idTeam, String nameteam, Ligue ligue, Match match) {
        this.idTeam = idTeam;
        this.nameteam = nameteam;
        this.ligue = ligue;
        this.match = match;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public String getNameteam() {
        return nameteam;
    }

    public void setNameteam(String nameteam) {
        this.nameteam = nameteam;
    }

    public Ligue getLigue() {
        return ligue;
    }

    public void setLigue(Ligue ligue) {
        this.ligue = ligue;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
