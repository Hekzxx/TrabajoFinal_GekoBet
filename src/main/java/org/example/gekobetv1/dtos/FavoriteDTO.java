package org.example.gekobetv1.dtos;
import org.example.gekobetv1.entities.Team;
import org.example.gekobetv1.entities.User;

public class FavoriteDTO {
    private int id;
    private UserDTO user;
    private TeamDTO team;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public TeamDTO getTeam() {
        return team;
    }

    public void setTeam(TeamDTO team) {
        this.team = team;
    }
}