package org.example.gekobetv1.dtos;
import org.example.gekobetv1.entities.User;

public class RoleDTO {
    private int id;
    private  String tipo;
    private User user;

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