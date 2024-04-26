package org.example.gekobetv1.servicesinterfaces;

import org.example.gekobetv1.entities.Team;

import java.util.List;

public interface ITeamService {
    public void insert(Team team);
    public List<Team> list();
    public void delete(int id);
    public Team listId(int id);
    public List<String[]> cantidadEquiposXLigaXTemporadaActual(String liga_ingresada);
    public List<String[]> teamsBySeason(int año_ingresado);
}
