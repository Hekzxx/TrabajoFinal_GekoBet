package org.example.gekobetv1.dtos;
import org.example.gekobetv1.entities.Team;

import java.time.LocalDate;

public class RecordDTO {
    private int id;
    private LocalDate dateRecord;
    private Integer resultado;
    private TeamDTO team;

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

    public TeamDTO getTeam() {
        return team;
    }

    public void setTeam(TeamDTO team) {
        this.team = team;
    }
}
