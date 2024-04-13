package org.example.gekobetv1.controllers;

import org.example.gekobetv1.dtos.FavoriteDTO;
import org.example.gekobetv1.dtos.UserDTO;
import org.example.gekobetv1.entities.Favorite;
import org.example.gekobetv1.entities.User;
import org.example.gekobetv1.servicesinterfaces.IFavoriteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/favorities")
public class FavoriteController {
    @Autowired
    private IFavoriteService fS;
    @PostMapping
    public void registrar(@RequestBody FavoriteDTO f){
        ModelMapper m=new ModelMapper();
        Favorite fa = m.map(f, Favorite.class);
        fS.insert(fa);
    }
    @GetMapping
    public List<FavoriteDTO> list(){
        return fS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,FavoriteDTO.class);
        }).collect(Collectors.toList());
    }
    @PutMapping
    public void Editar(@RequestBody FavoriteDTO f){
        ModelMapper m=new ModelMapper();
        Favorite fa = m.map(f,Favorite.class);
        fS.insert(fa);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        fS.delete(id);
    }
    @GetMapping("/{id}")
    public FavoriteDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        FavoriteDTO dto=m.map(fS.listId(id),FavoriteDTO.class);
        return dto;
    }
}