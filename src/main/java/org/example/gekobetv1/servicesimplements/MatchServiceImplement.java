package org.example.gekobetv1.servicesimplements;

import org.example.gekobetv1.entities.Match;
import org.example.gekobetv1.repositories.IMatchRepository;
import org.example.gekobetv1.repositories.ITicketRepository;
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
}