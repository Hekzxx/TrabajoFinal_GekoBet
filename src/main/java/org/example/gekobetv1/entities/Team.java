package org.example.gekobetv1.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "Team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nameteam", nullable = false, length = 40)
    private String nameteam;

    @ManyToOne
    @JoinColumn(name = "idLigue")
    private Ligue ligue;

    public Team() {
    }

    public Team(int id, String nameteam, Ligue ligue) {
        this.id = id;
        this.nameteam = nameteam;
        this.ligue = ligue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameteam() {
        return nameteam;
    }

    public void setNameteam(String nameteam) {
        this.nameteam = nameteam;
    }

    public Ligue getLigue() {
        return ligue;
    }

    public void setLigue(Ligue ligue) {
        this.ligue = ligue;
    }
}