package org.example.gekobetv1.controllers;

import org.example.gekobetv1.dtos.CountryDTO;
import org.example.gekobetv1.dtos.UserDTO;
import org.example.gekobetv1.entities.Country;
import org.example.gekobetv1.entities.User;
import org.example.gekobetv1.servicesinterfaces.ICountryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/countries")
@PreAuthorize("hasAuthority('ADMIN')")
public class CountryController {
    @Autowired
    private ICountryService cS;
    @PostMapping
    public void registrar(@RequestBody CountryDTO c){
        ModelMapper m=new ModelMapper();
        Country co=m.map(c,Country.class);
        cS.insert(co);
    }
    @GetMapping
    public List<CountryDTO> list(){

        return cS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,CountryDTO.class);
        }).collect(Collectors.toList());
    }
    @PutMapping
    public void Editar(@RequestBody CountryDTO c){
        ModelMapper m=new ModelMapper();
        Country co = m.map(c,Country.class);
        cS.insert(co);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        cS.delete(id);
    }

    @GetMapping("/{id}")
    public CountryDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        CountryDTO dto=m.map(cS.listID(id),CountryDTO.class);
        return dto;
    }

}