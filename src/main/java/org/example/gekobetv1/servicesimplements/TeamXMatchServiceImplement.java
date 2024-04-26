package org.example.gekobetv1.servicesimplements;
import org.example.gekobetv1.entities.TeamXMatch;
import org.example.gekobetv1.repositories.ITeamXMatchRepository;
import org.example.gekobetv1.servicesinterfaces.ITeamXMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamXMatchServiceImplement implements ITeamXMatchService {
    @Autowired
    private ITeamXMatchRepository tmR;

    @Override
    public void insert(TeamXMatch teamxmatch) {
        tmR.save(teamxmatch);
    }

    @Override
    public List<TeamXMatch> list() {
        return tmR.findAll();
    }

    @Override
    public void delete(int id) {
        tmR.deleteById(id);
    }

    @Override
    public TeamXMatch listId(int id) {
        return tmR.findById(id).orElse(new TeamXMatch());
    }
}
