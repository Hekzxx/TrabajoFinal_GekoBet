package org.example.gekobetv1.controllers;

import org.example.gekobetv1.dtos.RoleDTO;
import org.example.gekobetv1.dtos.UserDTO;
import org.example.gekobetv1.entities.Role;
import org.example.gekobetv1.entities.User;
import org.example.gekobetv1.servicesinterfaces.IRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private IRoleService rS;
    @PostMapping
    public void registrar(@RequestBody RoleDTO r){
        ModelMapper m=new ModelMapper();
        Role ro = m.map(r, Role.class);
        rS.insert(ro);
    }
    @GetMapping
    public List<RoleDTO> list(){
        return rS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,RoleDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping
    public void Editar(@RequestBody RoleDTO r){
        ModelMapper m=new ModelMapper();
        Role ro = m.map(r,Role.class);
        rS.insert(ro);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        rS.delete(id);
    }
    @GetMapping("/{id}")
    public RoleDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        RoleDTO dto=m.map(rS.listId(id),RoleDTO.class);
        return dto;
    }
    @GetMapping("/buscarXtipo")
    public List<RoleDTO> buscarTipo(@RequestParam String tipo){

        return rS.findByTipo(tipo).stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,RoleDTO.class);
        }).collect(Collectors.toList());
    }
}
