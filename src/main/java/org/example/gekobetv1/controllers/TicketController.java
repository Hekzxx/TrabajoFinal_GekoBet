package org.example.gekobetv1.controllers;
import org.example.gekobetv1.dtos.TicketDTO;
import org.example.gekobetv1.dtos.QueryTicketTicketXTeamDTO;
import org.example.gekobetv1.dtos.QueryTicketTicketsXPaisDTO;
import org.example.gekobetv1.entities.Ticket;
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
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public void registrar(@RequestBody TicketDTO t){
        ModelMapper m=new ModelMapper();
        Ticket ti = m.map(t, Ticket.class);
        tS.insert(ti);
    }
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public List<TicketDTO> list(){
        return tS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,TicketDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/Tickets_por_pais/{pais_ingresado}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public List<QueryTicketTicketsXPaisDTO> cantidadTicketsPais(@PathVariable("pais_ingresado") String pais_ingresado){
        List<String[]> filaLista= tS.cantidadTicketsXPais(pais_ingresado);
        List<QueryTicketTicketsXPaisDTO> dtoLista = new ArrayList<>();
        for(String[] columna:filaLista){
            QueryTicketTicketsXPaisDTO dto = new QueryTicketTicketsXPaisDTO();
            dto.setCantidad_tickets(Integer.parseInt(columna[0]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/Probabilidad_por_equipo")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public List<QueryTicketTicketXTeamDTO> ProbabilidadesPais(){
        List<String[]> filaLista= tS.Probabilidadporequipo();
        List<QueryTicketTicketXTeamDTO> dtoLista = new ArrayList<>();
        for(String[] columna:filaLista){
            QueryTicketTicketXTeamDTO dto = new QueryTicketTicketXTeamDTO();
            dto.setNombre_equipo(columna[0]);
            dto.setPromedio_probabilidad(Float.parseFloat(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public void Editar(@RequestBody TicketDTO t){
        ModelMapper m=new ModelMapper();
        Ticket ti = m.map(t,Ticket.class);
        tS.insert(ti);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public void eliminar(@PathVariable("id") Integer id){
        tS.delete(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public TicketDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        TicketDTO dto=m.map(tS.listId(id),TicketDTO.class);
        return dto;
    }

}