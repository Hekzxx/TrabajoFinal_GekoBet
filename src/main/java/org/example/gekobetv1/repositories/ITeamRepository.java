package org.example.gekobetv1.repositories;

import org.example.gekobetv1.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITeamRepository extends JpaRepository<Team, Integer> {

    @Query(value = "SELECT COUNT(t.id) AS cantidad_equipos\n" +
            "FROM team t\n" +
            "JOIN ligue l ON t.id_ligue = l.id\n" +
            "JOIN season s ON l.id_season = s.id\n" +
            "WHERE s.year = EXTRACT(YEAR FROM CURRENT_DATE) \n" +
            "AND l.nameligue = :liga_ingresada", nativeQuery = true)
    public List<String[]> cantidadEquiposXLigaXTemporadaActual(String liga_ingresada);



}
