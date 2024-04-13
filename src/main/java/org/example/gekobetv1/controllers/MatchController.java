package org.example.gekobetv1.controllers;
import org.example.gekobetv1.dtos.MatchDTO;
import org.example.gekobetv1.dtos.UserDTO;
import org.example.gekobetv1.entities.Match;
import org.example.gekobetv1.entities.User;
import org.example.gekobetv1.servicesinterfaces.IMatchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Matches")
public class MatchController {
    @Autowired
    private IMatchService mS;
    @PostMapping
    public void registrar(@RequestBody MatchDTO mt){
        ModelMapper m=new ModelMapper();
        Match ma = m.map(mt, Match.class);
        mS.insert(ma);
    }
    @GetMapping
    public List<MatchDTO> list(){
        return mS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,MatchDTO.class);
        }).collect(Collectors.toList());
    }
    @PutMapping
    public void Editar(@RequestBody MatchDTO mt){
        ModelMapper m=new ModelMapper();
        Match ma = m.map(mt,Match.class);
        mS.insert(ma);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        mS.delete(id);
    }
    @GetMapping("/{id}")
    public MatchDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        MatchDTO dto=m.map(mS.listId(id),MatchDTO.class);
        return dto;
    }
}
