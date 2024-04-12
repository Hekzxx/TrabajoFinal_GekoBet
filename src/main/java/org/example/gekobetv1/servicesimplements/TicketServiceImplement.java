package org.example.gekobetv1.servicesimplements;
import org.example.gekobetv1.entities.Ticket;
import org.example.gekobetv1.repositories.ITicketRepository;
import org.example.gekobetv1.servicesinterfaces.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImplement implements ITicketService {
    @Autowired
    private ITicketRepository tR;
    @Override
    public void insert(Ticket ticket) {
        tR.save(ticket);
    }

    @Override
    public List<Ticket> list() { return tR.findAll(); }

    @Override
    public void delete(int id) { tR.deleteById(id); }

    @Override
    public Ticket listId(int id) {
        return tR.findById(id).orElse(new Ticket());
    }
}
