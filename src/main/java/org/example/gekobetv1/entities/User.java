package org.example.gekobetv1.entities;
import jakarta.persistence.*;


@Entity
@Table(name = "Usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username",nullable = false,length = 40)
    private  String username;
    @Column(name = "password",nullable = false,length = 40)
    private String password;
    @Column(name = "mail",nullable = false,length = 40)
    private String mail;
    @Column(name = "estado",nullable = false,length = 40)
    private Boolean estado;
    @Column(name = "address",nullable = false,length = 40)
    private String address;
    @Column(name = "phone",nullable = false,length = 40)
    private String phone;
    @Column(name = "dni",nullable = false,length = 40)
    private String dni;

    public User() {
    }

    public User(int id, String username, String password, String mail, Boolean estado, String address, String phone, String dni) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.estado = estado;
        this.address = address;
        this.phone = phone;
        this.dni = dni;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
