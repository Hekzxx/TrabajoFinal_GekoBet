package org.example.gekobetv1.servicesinterfaces;

import org.example.gekobetv1.entities.TeamXMatch;

import java.util.List;

public interface ITeamXMatchService {
    public void insert(TeamXMatch teamxmatch);
    public List<TeamXMatch> list();
    public void delete(int id);
    public TeamXMatch listId(int id);
}