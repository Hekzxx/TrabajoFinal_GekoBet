package org.example.gekobetv1.controllers;
import org.example.gekobetv1.dtos.TeamXMatchDTO;
import org.example.gekobetv1.entities.TeamXMatch;
import org.example.gekobetv1.servicesinterfaces.ITeamXMatchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teamsxmatches")
//@PreAuthorize("hasAuthority('ADMIN')")
public class TeamXMatchController {
    @Autowired
    private ITeamXMatchService tmS;
    @PostMapping
    public void registrar(@RequestBody TeamXMatchDTO tm){
        ModelMapper m=new ModelMapper();
        TeamXMatch te = m.map(tm, TeamXMatch.class);
        tmS.insert(te);
    }
    @GetMapping
    public List<TeamXMatchDTO> list(){
        return tmS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,TeamXMatchDTO.class);
        }).collect(Collectors.toList());
    }
    @PutMapping
    public void Editar(@RequestBody TeamXMatchDTO t){
        ModelMapper m=new ModelMapper();
        TeamXMatch tm = m.map(t,TeamXMatch.class);
        tmS.insert(tm);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        tmS.delete(id);
    }

    @GetMapping("/{id}")
    public TeamXMatchDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        TeamXMatchDTO dto=m.map(tmS.listId(id),TeamXMatchDTO.class);
        return dto;
    }

}