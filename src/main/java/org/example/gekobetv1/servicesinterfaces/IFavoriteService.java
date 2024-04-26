package org.example.gekobetv1.servicesinterfaces;

import org.example.gekobetv1.entities.Favorite;

import java.util.List;

public interface IFavoriteService {
    public void insert(Favorite favorite);
    public List<Favorite> list();
    public void delete(int id);
    public Favorite listId(int id);
    public List<String[]> equiposFavoritosXpais(int id_usuario);
}