package org.example.gekobetv1.entities;
import jakarta.persistence.*;


@Entity
@Table(name = "Country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "namecountry",nullable = false,length = 40)
    private  String namecountry;

    public Country() {
    }

    public Country(int id, String namecountry) {
        this.id = id;
        this.namecountry = namecountry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamecountry() {
        return namecountry;
    }

    public void setNamecountry(String namecountry) {
        this.namecountry = namecountry;
    }
}
