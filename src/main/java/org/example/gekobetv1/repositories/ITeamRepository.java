package org.example.gekobetv1.repositories;

import org.example.gekobetv1.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITeamRepository extends JpaRepository<Team, Integer> {

    @Query(value = "select count (distinct t.id) as cantidad_equipo_temporada \n" +
            "from team t \n" +
            "inner join ligue l on l.id = t.id_ligue \n" +
            "inner join season s on s.id = l.id_season \n" +
            "where s.year = 2024", nativeQuery = true)
    public List<String[]> cantEquipoTemporadaActual();
    @Query(value = "select distinct t.nameteam from team t \n" +
            "inner join favorite f on f.id_team = t.id \n" +
            "inner join usuario u on u.id = f.id_user \n" +
            "inner join ligue l on l.id = t.id_ligue \n" +
            "inner join season s on s.id = l.id_season \n" +
            "inner join country c on c.id = s.id_country \n" +
            "where c.namecountry = :pais_ingresado \n" +
            "and u.id = :id_usuario", nativeQuery = true)
    public List<String[]> listaEquipoFavoritoXPais(String pais_ingresado, int id_usuario);
}