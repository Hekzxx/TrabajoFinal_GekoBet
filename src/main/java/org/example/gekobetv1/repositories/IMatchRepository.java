package org.example.gekobetv1.repositories;

import org.example.gekobetv1.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMatchRepository extends JpaRepository<Match,Integer> {
    @Query(value = "select count (Distinct m.id) as cantidad_partidos \n" +
            "from match m \n" +
            "inner join teamsxmatches tm on m.id = tm.id_match \n" +
            "inner join team t on t.id = tm.id_team \n" +
            "inner join ligue l on l.id = t.id_ligue \n" +
            "inner join season s on s.id = l.id_season \n" +
            "where s.year = :anio_ingresado", nativeQuery = true)
    public List<String[]> cantidadPartidosXTemporada(int anio_ingresado);
}
