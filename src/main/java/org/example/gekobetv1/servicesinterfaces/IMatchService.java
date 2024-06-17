package org.example.gekobetv1.servicesinterfaces;

import org.example.gekobetv1.entities.Match;
import org.example.gekobetv1.entities.Team;

import java.util.List;

public interface IMatchService {
    public void insert(Match match);
    public List<Match> list();
    public void delete(int id);
    public Match listId(int id);
    public List<String[]> cantidadPartidosXTemporada(int anio_ingresado);
    public List<String[]> PartidosXLiga(String liga_ingresada);
    public List<String[]> EquiposxTempo(int anio_ingresada);
    public float ProbabilidadEquipo(int teamrecord, int idmatchingresado);
    public float ObtenerGolesdeEquipo(int idteam);
    public List<String[]> ObtenerEquipoSegunPartido(int idmatch);
}