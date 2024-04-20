package org.example.gekobetv1.dtos;
import org.example.gekobetv1.entities.Ligue;
import org.example.gekobetv1.entities.Match;

public class TeamDTO {
    private int id;
    private String nameteam;
    private LigueDTO ligue;
    private MatchDTO match;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameteam() {
        return nameteam;
    }

    public void setNameteam(String nameteam) {
        this.nameteam = nameteam;
    }

    public LigueDTO getLigue() {
        return ligue;
    }

    public void setLigue(LigueDTO ligue) {
        this.ligue = ligue;
    }

    public MatchDTO getMatch() {
        return match;
    }

    public void setMatch(MatchDTO match) {
        this.match = match;
    }
}