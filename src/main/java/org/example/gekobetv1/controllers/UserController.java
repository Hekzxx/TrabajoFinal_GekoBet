package org.example.gekobetv1.controllers;
import org.example.gekobetv1.dtos.UserDTO;
import org.example.gekobetv1.entities.User;
import org.example.gekobetv1.servicesinterfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService uS;
    @PostMapping
    public void registrar(@RequestBody UserDTO u){
        ModelMapper m=new ModelMapper();
        User us = m.map(u,User.class);
        uS.insert(us);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public List<UserDTO> list(){

        return uS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,UserDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public void Editar(@RequestBody UserDTO u){
        ModelMapper m=new ModelMapper();
        User us = m.map(u,User.class);
        uS.insert(us);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public void eliminar(@PathVariable("id") Integer id){
        uS.delete(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public UserDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        UserDTO dto=m.map(uS.listId(id),UserDTO.class);
        return dto;
    }

}
