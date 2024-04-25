package org.example.gekobetv1.dtos;
import org.example.gekobetv1.entities.Ticket;

import java.time.LocalDate;

public class MatchDTO {
    private int id;
    private LocalDate dateMatch;
    private  String versus;
    private TeamDTO team1;
    private TeamDTO team2;

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

    public TeamDTO getTeam1() {
        return team1;
    }

    public void setTeam1(TeamDTO team1) {
        this.team1 = team1;
    }

    public TeamDTO getTeam2() {
        return team2;
    }

    public void setTeam2(TeamDTO team2) {
        this.team2 = team2;
    }
}