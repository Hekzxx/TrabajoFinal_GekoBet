package org.example.gekobetv1.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "dateMatch", nullable = false)
    private LocalDate dateMatch;
    @Column(name = "versus",nullable = false,length = 40)
    private  String versus;

    @ManyToOne
    @JoinColumn(name = "idTeam1")
    private Team team1;

    @ManyToOne
    @JoinColumn(name = "idTeam2")
    private Team team2;

    public Match() {
    }

    public Match(int id, LocalDate dateMatch, String versus, Team team1, Team team2) {
        this.id = id;
        this.dateMatch = dateMatch;
        this.versus = versus;
        this.team1 = team1;
        this.team2 = team2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateMatch() {
        return dateMatch;
    }

    public void setDateMatch(LocalDate dateMatch) {
        this.dateMatch = dateMatch;
    }

    public String getVersus() {
        return versus;
    }

    public void setVersus(String versus) {
        this.versus = versus;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }
}
