package org.example.gekobetv1.dtos;

import org.example.gekobetv1.entities.Country;

public class SeasonDTO {
    private int id;
    private  Integer tipo;
    private Country country;

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
