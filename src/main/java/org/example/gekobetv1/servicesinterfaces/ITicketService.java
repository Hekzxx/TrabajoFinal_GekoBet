package org.example.gekobetv1.servicesinterfaces;

import org.example.gekobetv1.entities.Ticket;

import java.util.List;

public interface ITicketService {
    public void insert(Ticket ticket);
    public List<Ticket> list();
    public List<String[]> cantidadTicketsXPais(String pais_ingresado);
    public void delete(int id);
    public Ticket listId(int id);
}
