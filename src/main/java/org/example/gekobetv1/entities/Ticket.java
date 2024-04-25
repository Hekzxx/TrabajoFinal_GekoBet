package org.example.gekobetv1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "probabilidad",nullable = false,length = 10)
    private  Float probabilidad;

    @Column(name = "equipoGanador",nullable = false,length = 40)
    private  String equipoGanador;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idMatch")
    private Match match;

    public Ticket() {
    }

    public Ticket(int id, Float probabilidad, String equipoGanador, User user, Match match) {
        this.id = id;
        this.probabilidad = probabilidad;
        this.equipoGanador = equipoGanador;
        this.user = user;
        this.match = match;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
