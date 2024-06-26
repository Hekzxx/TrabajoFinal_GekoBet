package org.example.gekobetv1.servicesimplements;
import org.example.gekobetv1.entities.Match;
import org.example.gekobetv1.entities.Team;
import org.example.gekobetv1.repositories.IMatchRepository;
import org.example.gekobetv1.servicesinterfaces.IMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImplement implements IMatchService {
    @Autowired
    private IMatchRepository mR;
    @Override
    public void insert(Match match) {
        mR.save(match);
    }

    @Override
    public List<Match> list() { return mR.findAll(); }

    @Override
    public void delete(int id) { mR.deleteById(id); }

    @Override
    public Match listId(int id) {
        return mR.findById(id).orElse(new Match());
    }

    @Override
    public List<String[]> cantidadPartidosXTemporada(int anio_ingresado) {
        return mR.cantidadPartidosXTemporada(anio_ingresado);
    }

    @Override
    public List<String[]> PartidosXLiga(String liga_ingresada) {
        return mR.PartidosXLiga(liga_ingresada);
    }

    @Override
    public List<String[]> EquiposxTempo(int anio_ingresada) {
        return mR.EquiposxTempo(anio_ingresada);
    }

    @Override
    public float ProbabilidadEquipo(int teamrecord, int idmatchingresado) {
        return mR.ProbabilidadEquipo(teamrecord,idmatchingresado);
    }

    @Override
    public float ObtenerGolesdeEquipo(int idteam) {
        return mR.ObtenerGolesdeEquipo(idteam);
    }

    @Override
    public List<String[]> ObtenerEquipoSegunPartido(int idm) {
        return mR.ObtenerEquipoSegunPartido(idm);
    }

    @Override
    public int UltimoMatchCreado() {return mR.UltimoMatchCreado();}


}