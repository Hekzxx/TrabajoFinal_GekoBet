package org.example.gekobetv1.controllers;
import org.example.gekobetv1.dtos.SeasonDTO;
import org.example.gekobetv1.entities.Season;
import org.example.gekobetv1.servicesinterfaces.ISeasonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/seasons")
@PreAuthorize("hasAuthority('ADMIN')")
public class SeasonController {
    @Autowired
    private ISeasonService sS;
    @PostMapping
    public void registrar(@RequestBody SeasonDTO s){
        ModelMapper m=new ModelMapper();
        Season se = m.map(s, Season.class);
        sS.insert(se);
    }
    @GetMapping
    public List<SeasonDTO> list(){
        return sS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,SeasonDTO.class);
        }).collect(Collectors.toList());
    }
    @PutMapping
    public void Editar(@RequestBody SeasonDTO s){
        ModelMapper m=new ModelMapper();
        Season se = m.map(s,Season.class);
        sS.insert(se);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        sS.delete(id);
    }

    @GetMapping("/{id}")
    public SeasonDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        SeasonDTO dto=m.map(sS.listId(id),SeasonDTO.class);
        return dto;
    }
}