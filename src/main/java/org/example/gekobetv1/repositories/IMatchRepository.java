package org.example.gekobetv1.repositories;

import org.example.gekobetv1.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMatchRepository extends JpaRepository<Match,Integer> {
    @Query(value = "SELECT COUNT(*) AS cantidad_partidos\n" +
            "FROM match\n" +
            "INNER JOIN team AS team1 ON match.id_team1 = team1.id\n" +
            "INNER JOIN team AS team2 ON match.id_team2 = team2.id\n" +
            "INNER JOIN ligue ON (team1.id_ligue = ligue.id OR team2.id_ligue = ligue.id)\n" +
            "INNER JOIN season ON ligue.id_season = season.id\n" +
            "WHERE season.year = :anio_ingresado", nativeQuery = true)
    public List<String[]> cantidadPartidosXTemporada(int anio_ingresado);
}
