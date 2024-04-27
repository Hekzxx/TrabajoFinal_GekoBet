package org.example.gekobetv1.repositories;
import org.example.gekobetv1.entities.Ligue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILigueRepository extends JpaRepository<Ligue,Integer> {
    @Query(value = "select l.nameligue, s.year, c.namecountry from ligue l \n" +
            "inner join season s on s.id = l.id_season \n" +
            "inner join country c on c.id = s.id_country \n" +
            "where s.year = :anio_ingresado \n" +
            "and c.namecountry = :pais_ingresado", nativeQuery = true)
    public List<String[]> listaLigasxSeasonCountry(int anio_ingresado, String pais_ingresado);
}