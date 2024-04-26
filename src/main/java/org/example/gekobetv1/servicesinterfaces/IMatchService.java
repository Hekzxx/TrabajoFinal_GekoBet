package org.example.gekobetv1.servicesinterfaces;

import org.example.gekobetv1.entities.Match;

import java.util.List;

public interface IMatchService {
    public void insert(Match match);
    public List<Match> list();
    public void delete(int id);
    public Match listId(int id);
    public List<String[]> cantidadPartidosXTemporada(int anio_ingresado);
    public List<String[]> PartidosXLiga(String liga_ingresada);
}