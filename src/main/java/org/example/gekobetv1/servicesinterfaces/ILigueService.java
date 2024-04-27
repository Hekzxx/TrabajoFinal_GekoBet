package org.example.gekobetv1.servicesinterfaces;

import org.example.gekobetv1.entities.Ligue;

import java.util.List;

public interface ILigueService {
    public void insert(Ligue ligue);
    public List<Ligue> list();
    public List<String[]> listaLigasxSeasonCountry(int anio_ingresado, String pais_ingresado);
    public void delete(int id);
}