package org.example.gekobetv1.dtos;
import org.example.gekobetv1.entities.Team;
import org.example.gekobetv1.entities.User;

public class FavoriteDTO {
    private int id;
    private User user;
    private Team team;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}