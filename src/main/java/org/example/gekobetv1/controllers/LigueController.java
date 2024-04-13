package org.example.gekobetv1.controllers;

import org.example.gekobetv1.dtos.LigueDTO;
import org.example.gekobetv1.dtos.UserDTO;
import org.example.gekobetv1.entities.Ligue;
import org.example.gekobetv1.entities.User;
import org.example.gekobetv1.servicesinterfaces.ILigueService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ligues")
public class LigueController {
    @Autowired
    private ILigueService lS;
    @PostMapping
    public void registrar(@RequestBody LigueDTO l){
        ModelMapper m=new ModelMapper();
        Ligue li = m.map(l, Ligue.class);
        lS.insert(li);
    }
    @GetMapping
    public List<LigueDTO> list(){
        return lS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,LigueDTO.class);
        }).collect(Collectors.toList());
    }
    @PutMapping
    public void Editar(@RequestBody LigueDTO l){
        ModelMapper m=new ModelMapper();
        Ligue li = m.map(l,Ligue.class);
        lS.insert(li);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        lS.delete(id);
    }
    @GetMapping("/{id}")
    public LigueDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        LigueDTO dto=m.map(lS.listId(id),LigueDTO.class);
        return dto;
    }
}