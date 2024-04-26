package org.example.gekobetv1.servicesinterfaces;

import org.example.gekobetv1.entities.Favorite;

import java.util.List;

public interface IFavoriteService {
    public void insert(Favorite favorite);
    public List<Favorite> list();
    public List<String[]> listaEquipoFavorito(int id_usuario);

    public void delete(int id);
    public Favorite listId(int id);
}