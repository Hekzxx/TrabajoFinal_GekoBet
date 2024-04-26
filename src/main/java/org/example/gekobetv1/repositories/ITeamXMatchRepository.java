package org.example.gekobetv1.repositories;
import org.example.gekobetv1.entities.TeamXMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITeamXMatchRepository extends JpaRepository<TeamXMatch,Integer> {

    @Query(value = "select count (distinct m.id) as cantidad_partidos_jugados \n" +
            "from match m\n" +
            "inner join teamsxmatches tm on m.id = tm.id_match \n" +
            "inner join team t on t.id = tm.id_team \n" +
            "inner join ligue l on l.id = t.id_ligue \n" +
            "where l.nameligue = 'LigaMovistar' ", nativeQuery = true)
    public List<String[]> PartidosXLiga();
}
