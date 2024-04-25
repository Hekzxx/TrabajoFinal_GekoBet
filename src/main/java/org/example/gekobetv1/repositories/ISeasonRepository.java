package org.example.gekobetv1.repositories;

import org.example.gekobetv1.entities.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ISeasonRepository extends JpaRepository<Season,Integer> {
    @Query(value = "SELECT t.nameteam\n" +
            "FROM team t\n" +
            "INNER JOIN ligue l ON t.id_ligue = l.id\n" +
            "INNER JOIN season s ON l.id_season = s.id\n" +
            "WHERE s.year=:año_ingresado",nativeQuery = true)
    public List<String[]> teamsBySeason(int año_ingresado);
}