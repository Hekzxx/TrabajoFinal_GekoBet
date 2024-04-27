package org.example.gekobetv1.controllers;
import org.example.gekobetv1.dtos.UserDTO;
import org.example.gekobetv1.entities.User;
import org.example.gekobetv1.servicesinterfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<UserDTO> list(){

        return uS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,UserDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping
    public void Editar(@RequestBody UserDTO u){
        ModelMapper m=new ModelMapper();
        User us = m.map(u,User.class);
        uS.insert(us);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        uS.delete(id);
    }

}
