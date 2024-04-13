package org.example.gekobetv1.servicesimplements;

import org.example.gekobetv1.entities.Favorite;
import org.example.gekobetv1.repositories.IFavoriteRepository;
import org.example.gekobetv1.servicesinterfaces.IFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceImplement implements IFavoriteService {
    @Autowired
    private IFavoriteRepository fR;
    @Override
    public void insert(Favorite favorite) {
        fR.save(favorite);
    }

    @Override
    public List<Favorite> list() { return fR.findAll(); }

    @Override
    public void delete(int id) { fR.deleteById(id); }

    @Override
    public Favorite listId(int id) {
        return fR.findById(id).orElse(new Favorite());
    }
}