package org.example.gekobetv1.dtos;

public class EquiposFavoritosDTO {
    private String nameteam;
    private String nameligue;
    private int year;
    private String namecountry;

    public String getNameteam() {
        return nameteam;
    }

    public void setNameteam(String nameteam) {
        this.nameteam = nameteam;
    }

    public String getNameligue() {
        return nameligue;
    }

    public void setNameligue(String nameligue) {
        this.nameligue = nameligue;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getNamecountry() {
        return namecountry;
    }

    public void setNamecountry(String namecountry) {
        this.namecountry = namecountry;
    }
}
