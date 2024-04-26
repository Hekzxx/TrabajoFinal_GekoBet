package org.example.gekobetv1.dtos;
import org.example.gekobetv1.entities.Ticket;

import java.time.LocalDate;

public class MatchDTO {
    private int id;
    private LocalDate dateMatch;
    private  String versus;

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
}