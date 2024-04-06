package org.example.gekobetv1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Role")
public class Role {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "User_id")
    private User user;
    @Column(name = "tipo",nullable = false,length = 40)
    private  String tipo;

    public Role() {
    }

    public Role(int id, User user, String tipo) {
        this.id = id;
        this.user = user;
        this.tipo = tipo;
    }

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
