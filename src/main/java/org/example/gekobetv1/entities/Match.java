package org.example.gekobetv1.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "dateMatch", nullable = false)
    private LocalDate dateMatch;
    @Column(name = "versus",nullable = false,length = 40)
    private  String versus;

    @ManyToOne
    @JoinColumn(name = "idTicket")
    private Ticket ticket;

    public Match() {
    }

    public Match(int id, LocalDate dateMatch, String versus, Ticket ticket) {
        this.id = id;
        this.dateMatch = dateMatch;
        this.versus = versus;
        this.ticket = ticket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateMatch() {
        return dateMatch;
    }

    public void setDateMatch(LocalDate dateMatch) {
        this.dateMatch = dateMatch;
    }

    public String getVersus() {
        return versus;
    }

    public void setVersus(String versus) {
        this.versus = versus;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
