package org.example.gekobetv1.servicesinterfaces;

import org.example.gekobetv1.entities.Team;

import java.util.List;

public interface ITeamService {
    public void insert(Team team);
    public List<Team> list();
    public List<String[]> cantEquipoTemporadaActual();
    public List<String[]> listaEquipoFavoritoXPais(String pais_ingresado, int id_usuario);
    public void delete(int id);
}