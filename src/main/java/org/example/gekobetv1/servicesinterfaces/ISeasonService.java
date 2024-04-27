package org.example.gekobetv1.servicesinterfaces;

import org.example.gekobetv1.entities.Season;

import java.util.List;

public interface ISeasonService {
    public void insert(Season season);
    public List<Season> list();
    public void delete(int id);
}