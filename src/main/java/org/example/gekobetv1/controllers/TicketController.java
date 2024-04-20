package org.example.gekobetv1.controllers;
import org.example.gekobetv1.dtos.PartidosXTemporadaDTO;
import org.example.gekobetv1.dtos.TicketDTO;
import org.example.gekobetv1.dtos.TicketsXTemporadaDTO;
import org.example.gekobetv1.dtos.UserDTO;
import org.example.gekobetv1.entities.Ticket;
import org.example.gekobetv1.entities.User;
import org.example.gekobetv1.servicesinterfaces.ITicketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private ITicketService tS;
    @PostMapping
    public void registrar(@RequestBody TicketDTO t){
        ModelMapper m=new ModelMapper();
        Ticket ti = m.map(t, Ticket.class);
        tS.insert(ti);
    }
    @GetMapping
    public List<TicketDTO> list(){
        return tS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,TicketDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/Tickets_por_temporada/{anio_ingresado}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<TicketsXTemporadaDTO> cantidadTicketsTemporada(@PathVariable("anio_ingresado") int anio_ingresado){
        List<String[]> filaLista= tS.cantidadTicketsXTemporada(anio_ingresado);
        List<TicketsXTemporadaDTO> dtoLista = new ArrayList<>();
        for(String[] columna:filaLista){
            TicketsXTemporadaDTO dto = new TicketsXTemporadaDTO();
            dto.setTotal_tickets(Integer.parseInt(columna[0]));

            dtoLista.add(dto);
        }
        return dtoLista;
    }
    @PutMapping
    public void Editar(@RequestBody TicketDTO t){
        ModelMapper m=new ModelMapper();
        Ticket ti = m.map(t,Ticket.class);
        tS.insert(ti);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        tS.delete(id);
    }
    @GetMapping("/{id}")
    public TicketDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        TicketDTO dto=m.map(tS.listId(id),TicketDTO.class);
        return dto;
    }
}
