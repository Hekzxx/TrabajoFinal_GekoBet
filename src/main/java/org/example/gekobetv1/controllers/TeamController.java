package org.example.gekobetv1.controllers;

import org.example.gekobetv1.dtos.*;
import org.example.gekobetv1.entities.Team;
import org.example.gekobetv1.entities.User;
import org.example.gekobetv1.servicesinterfaces.ITeamService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private ITeamService tS;
    @PostMapping
    public void registrar(@RequestBody TeamDTO t){
        ModelMapper m=new ModelMapper();
        Team te = m.map(t, Team.class);
        tS.insert(te);
    }
    @GetMapping
    public List<TeamDTO> list(){
        return tS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,TeamDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping
    public void Editar(@RequestBody TeamDTO t){
        ModelMapper m=new ModelMapper();
        Team te = m.map(t,Team.class);
        tS.insert(te);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        tS.delete(id);
    }
    @GetMapping("/{id}")
    public TeamDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        TeamDTO dto=m.map(tS.listId(id),TeamDTO.class);
        return dto;
    }




}
