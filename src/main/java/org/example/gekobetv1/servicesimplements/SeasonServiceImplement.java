package org.example.gekobetv1.servicesimplements;
import org.example.gekobetv1.entities.Season;
import org.example.gekobetv1.repositories.ISeasonRepository;
import org.example.gekobetv1.servicesinterfaces.ISeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonServiceImplement implements ISeasonService {
    @Autowired
    private ISeasonRepository sR;
    @Override
    public void insert(Season season) {
        sR.save(season);
    }

    @Override
    public List<Season> list() { return sR.findAll(); }

    @Override
    public void delete(int id) { sR.deleteById(id); }

    @Override
    public Season listId(int id) {
        return sR.findById(id).orElse(new Season());
    }
}
