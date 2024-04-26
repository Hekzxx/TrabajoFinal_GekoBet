package org.example.gekobetv1.repositories;

import org.example.gekobetv1.entities.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFavoriteRepository extends JpaRepository<Favorite,Integer> {
    @Query(value = "select distinct t.nameteam, l.nameligue, s.year, c.namecountry from favorite f \n" +
            "inner join team t on f.id_team = f.id \n" +
            "inner join ligue l on l.id = t.id_ligue \n" +
            "inner join season s on s.id = l.id_season \n" +
            "inner join country c on c.id = s.id_country \n" +
            "inner join usuario u on u.id = f.id_user \n" +
            "and u.id = :id_usuario", nativeQuery = true)
    public List<String[]> listaEquipoFavorito(int id_usuario);

}