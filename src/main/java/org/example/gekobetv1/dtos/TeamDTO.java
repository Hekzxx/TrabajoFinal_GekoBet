package org.example.gekobetv1.dtos;
import org.example.gekobetv1.entities.Ligue;
import org.example.gekobetv1.entities.Match;

public class TeamDTO {
    private int id;
    private String nameteam;
    private Ligue ligue;
    private Match match;

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