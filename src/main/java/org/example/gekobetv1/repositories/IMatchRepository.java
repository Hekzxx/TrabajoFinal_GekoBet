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
    @Query(value = "select count (distinct m.id) as cantidad_partidos_jugados \n" +
            "from match m\n" +
            "inner join teamsxmatches tm on m.id = tm.id_match \n" +
            "inner join team t on t.id = tm.id_team \n" +
            "inner join ligue l on l.id = t.id_ligue \n" +
            "where l.nameligue = :liga_ingresada ", nativeQuery = true)
    public List<String[]> PartidosXLiga(String liga_ingresada);

    @Query(value = "select t.nameteam, s.year from match m \n" +
            "inner join teamsxmatches tm on tm.id_match = m.id \n" +
            "inner join team t on t.id = tm.id_team \n" +
            "inner join ligue l on l.id = t.id_ligue \n" +
            "inner join season s on s.id = l.id_season \n" +
            "where s.year = :anio_ingresada", nativeQuery = true)
    public List<String[]> EquiposxTempo(int anio_ingresada);

    @Query(value = "select (100.0 * :teamrecord)/SUM(r.resultado) as probabilidaddelequipo from team t\n" +
            "inner join teamsxmatches txm on txm.id_team = t.id\n" +
            "inner join match m on txm.id_match = m.id\n" +
            "inner join record r on r.id_team = t.id\n" +
            "where m.id = :idmatchingresado", nativeQuery = true)
    public float ProbabilidadEquipo(int teamrecord, int idmatchingresado);

    @Query(value = "select SUM(r.resultado) from record r\n" +
            "inner join team t on r.id_team = t.id\n" +
            "where t.id = :idteam", nativeQuery = true)
    public float ObtenerGolesdeEquipo(int idteam);

    @Query(value = "select t.nameteam as nombreEQUIPO from team t\n" +
            "inner join teamsxmatches txm on txm.id_team=t.id\n" +
            "inner join match m on txm.id_match = m.id \n" +
            "where m.id= :idm ", nativeQuery = true)
    public List<String[]> ObtenerEquipoSegunPartido(int idm);

    @Query(value = "select m.id from match m order by m.id desc limit 1", nativeQuery = true)
    public int UltimoMatchCreado();
}
