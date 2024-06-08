package org.example.gekobetv1.servicesimplements;

import org.example.gekobetv1.entities.Ligue;
import org.example.gekobetv1.repositories.ILigueRepository;
import org.example.gekobetv1.servicesinterfaces.ILigueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigueServiceImplement implements ILigueService {
    @Autowired
    private ILigueRepository lR;
    @Override
    public void insert(Ligue ligue) {
        lR.save(ligue);
    }

    @Override
    public List<Ligue> list() { return lR.findAll(); }

    @Override
    public List<String[]> listaLigasxSeasonCountry(int anio_ingresado, String pais_ingresado) {
        return lR.listaLigasxSeasonCountry(anio_ingresado,pais_ingresado);
    }

    @Override
    public void delete(int id) { lR.deleteById(id); }

    @Override
    public Ligue listID(int id) {
        return lR.findById(id).orElse(new Ligue());
    }

}