package org.example.gekobetv1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TeamsXMatches")
public class TeamXMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "idTeam")
    private Team team;
    @ManyToOne
    @JoinColumn(name = "idMatch")
    private Match match;

    public TeamXMatch() {
    }

    public TeamXMatch(int id, Team team, Match match) {
        this.id = id;
        this.team = team;
        this.match = match;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
