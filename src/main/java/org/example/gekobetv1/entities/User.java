package org.example.gekobetv1.entities;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "Usuario")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username",nullable = false,length = 40)
    private  String username;
    @Column(name = "password",nullable = false,length = 200)
    private String password;
    @Column(name = "mail",nullable = false,length = 40)
    private String mail;
    @Column(name = "estado",nullable = false,length = 40)
    private Boolean estado;
    @Column(name = "address",nullable = false,length = 40)
    private String address;
    @Column(name = "phone",nullable = false)
    private Integer phone;
    @Column(name = "dni",nullable = false)
    private Integer dni;
    private Boolean enabled;

    public User() {
    }
    public User(int id, String username, String password, String mail, Boolean estado, String address, Integer phone, Integer dni, Boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.estado = estado;
        this.address = address;
        this.phone = phone;
        this.dni = dni;
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}