package org.example.gekobetv1.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Season")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "year",nullable = false)
    private  Integer tipo;

    @ManyToOne
    @JoinColumn(name = "idCountry")
    private Country country;

    public Season() {
    }

    public Season(int id, Integer tipo, Country country) {
        this.id = id;
        this.tipo = tipo;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}