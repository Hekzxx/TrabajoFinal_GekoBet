package org.example.gekobetv1.servicesinterfaces;

import org.example.gekobetv1.entities.Match;

import java.util.List;

public interface IMatchService {
    public void insert(Match match);
    public List<Match> list();
    public void delete(int id);
    public Match listId(int id);
}