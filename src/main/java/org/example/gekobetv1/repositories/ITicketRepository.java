package org.example.gekobetv1.repositories;
import org.example.gekobetv1.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketRepository extends JpaRepository<Ticket,Integer> {
}
