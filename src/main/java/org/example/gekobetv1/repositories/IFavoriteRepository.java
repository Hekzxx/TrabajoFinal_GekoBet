package org.example.gekobetv1.repositories;

import org.example.gekobetv1.entities.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFavoriteRepository extends JpaRepository<Favorite,Integer> {

    @Query(value = "SELECT t.nameteam, c.namecountry\n" +
            "FROM favorite f\n" +
            "JOIN team t ON f.id_team = t.id\n" +
            "JOIN ligue l ON t.id_ligue = l.id\n" +
            "JOIN season s ON l.id_season = s.id\n" +
            "JOIN country c ON s.id_country = c.id\n" +
            "WHERE f.id_user = :id_usuario", nativeQuery = true)
    public List<String[]> equiposFavoritosXpais(int id_usuario);

}