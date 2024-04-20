package org.example.gekobetv1.repositories;
import org.example.gekobetv1.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITicketRepository extends JpaRepository<Ticket,Integer> {
    @Query(value = "SELECT COUNT(*) AS total_tickets \n" +
            "FROM ticket ti \n" +
            "INNER JOIN match m ON m.id_ticket = ti.id \n" +
            "INNER JOIN team t ON t.id_match = m.id \n" +
            "INNER JOIN ligue l ON t.id_ligue = l.id \n" +
            "INNER JOIN season s ON l.id_season = s.id \n" +
            "INNER JOIN country c on s.id_country = c.id \n" +
            "WHERE c.namecountry = :pais_ingresado", nativeQuery = true)
    public List<String[]> cantidadTicketsXPais(String pais_ingresado);


}
