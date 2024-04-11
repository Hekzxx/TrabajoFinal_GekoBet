package org.example.gekobetv1.dtos;

import org.example.gekobetv1.entities.Country;

public class SeasonDTO {
    private int id;
    private  Integer year;
    private Country country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
