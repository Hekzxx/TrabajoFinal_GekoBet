package org.example.gekobetv1.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Role" )
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tipo",nullable = false,length = 40)
    private  String tipo;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    public Role() {
    }

    public Role(int id, String tipo, User user) {
        this.id = id;
        this.tipo = tipo;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}