package org.example.gekobetv1.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "dateRecord", nullable = false)
    private LocalDate dateRecord;
    @Column(name = "resultado",nullable = false)
    private Integer resultado;

    @ManyToOne
    @JoinColumn(name = "idTeam")
    private Team team;

    public Record() {
    }

    public Record(int id, LocalDate dateRecord, Integer resultado, Team team) {
        this.id = id;
        this.dateRecord = dateRecord;
        this.resultado = resultado;
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateRecord() {
        return dateRecord;
    }

    public void setDateRecord(LocalDate dateRecord) {
        this.dateRecord = dateRecord;
    }

    public Integer getResultado() {
        return resultado;
    }

    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
