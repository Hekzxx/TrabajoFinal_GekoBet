package org.example.gekobetv1.servicesinterfaces;

import org.example.gekobetv1.entities.Ticket;

import java.util.List;

public interface ITicketService {
    public void insert(Ticket ticket);
    public List<Ticket> list();
    public List<String[]> cantidadTicketsXTemporada(int anio_ingresado);
    public void delete(int id);
    public Ticket listId(int id);
}
