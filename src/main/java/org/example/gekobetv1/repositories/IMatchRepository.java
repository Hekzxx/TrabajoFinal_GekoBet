package org.example.gekobetv1.repositories;

import org.example.gekobetv1.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMatchRepository extends JpaRepository<Match,Integer> {
    @Query(value = "Select count (*) as total_partidos \n" +
            "from Match m \n" +
            "INNER JOIN Team t ON t.id_match = m.id \n" +
            "INNER JOIN Ligue l ON t.id_ligue = l.id \n" +
            "INNER JOIN Season s ON l.id_season = s.id \n" +
            "WHERE s.year = :anio_ingresado", nativeQuery = true)
    public List<String[]> cantidadPartidosXTemporada(int anio_ingresado);
}
