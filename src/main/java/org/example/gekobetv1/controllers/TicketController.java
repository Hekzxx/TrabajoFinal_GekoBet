package org.example.gekobetv1.controllers;
import org.example.gekobetv1.dtos.TicketDTO;
import org.example.gekobetv1.dtos.UserDTO;
import org.example.gekobetv1.entities.Ticket;
import org.example.gekobetv1.entities.User;
import org.example.gekobetv1.servicesinterfaces.ITicketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
