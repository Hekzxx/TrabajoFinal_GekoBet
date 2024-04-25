package org.example.gekobetv1.dtos;
import org.example.gekobetv1.entities.User;

public class TicketDTO {
    private int id;
    private  Float probabilidad;
    private  String equipoGanador;
    private UserDTO user;
    private MatchDTO match;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getProbabilidad() {
        return probabilidad;
    }

    public void setProbabilidad(Float probabilidad) {
        this.probabilidad = probabilidad;
    }

    public String getEquipoGanador() {
        return equipoGanador;
    }

    public void setEquipoGanador(String equipoGanador) {
        this.equipoGanador = equipoGanador;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public MatchDTO getMatch() {
        return match;
    }

    public void setMatch(MatchDTO match) {
        this.match = match;
    }
}
