package org.example.gekobetv1.dtos;

import org.example.gekobetv1.entities.Country;

public class SeasonDTO {
    private int id;
    private  Integer year;
    private CountryDTO country;

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

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }
}
