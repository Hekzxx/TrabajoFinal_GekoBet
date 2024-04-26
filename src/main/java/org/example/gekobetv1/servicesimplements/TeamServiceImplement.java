package org.example.gekobetv1.servicesimplements;

import org.example.gekobetv1.entities.Team;
import org.example.gekobetv1.repositories.ITeamRepository;
import org.example.gekobetv1.servicesinterfaces.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImplement implements ITeamService {
    @Autowired
    private ITeamRepository tR;
    @Override
    public void insert(Team team) {
        tR.save(team);
    }

    @Override
    public List<Team> list() { return tR.findAll(); }

    @Override
    public void delete(int id) { tR.deleteById(id); }

    @Override
    public Team listId(int id) {
        return tR.findById(id).orElse(new Team());
    }

}