package org.example.gekobetv1.repositories;
import org.example.gekobetv1.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITicketRepository extends JpaRepository<Ticket,Integer> {
    @Query(value = "select count (Distinct ti.id) as cantidad_tickets \n" +
            "from ticket ti \n" +
            "inner join match m on m.id = ti.id_match \n" +
            "inner join teamsxmatches tm on tm.id_match = m.id \n" +
            "inner join team t on  t.id = tm.id_team \n" +
            "inner join ligue l on l.id = t.id_ligue \n" +
            "inner join season s on s.id = l.id_season \n" +
            "inner join country c on c.id = s.id_country \n" +
            "where c.namecountry = :pais_ingresado", nativeQuery = true)
    public List<String[]> cantidadTicketsXPais(String pais_ingresado);


}
