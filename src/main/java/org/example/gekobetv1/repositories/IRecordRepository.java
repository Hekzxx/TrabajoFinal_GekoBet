package org.example.gekobetv1.repositories;
import org.example.gekobetv1.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRecordRepository extends JpaRepository<Record,Integer> {
    @Query(value = "select t.nameteam, r.resultado from record r \n" +
            "inner join Team t on t.id = r.id_team \n" +
            "inner join favorite f on f.id_team = t.id \n" +
            "inner join usuario u on u.id = f.id_user \n" +
            "where u.id= :id_usuario ", nativeQuery = true)
    public List<String[]> cantVictoriasEquipoFavorito(int id_usuario);
}