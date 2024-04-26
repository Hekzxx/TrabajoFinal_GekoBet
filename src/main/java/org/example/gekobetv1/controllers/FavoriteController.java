package org.example.gekobetv1.controllers;

import org.example.gekobetv1.dtos.*;
import org.example.gekobetv1.entities.Country;
import org.example.gekobetv1.entities.Favorite;
import org.example.gekobetv1.entities.Team;
import org.example.gekobetv1.entities.User;
import org.example.gekobetv1.servicesinterfaces.IFavoriteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @GetMapping("/Equipos_favoritos/{id_usuario}")
    public List<EquiposFavoritosDTO> equiposFavoritos(@PathVariable("id_usuario") String id_usuario){
        List<String[]> filaLista= fS.listaEquipoFavorito(Integer.parseInt(id_usuario));
        List<EquiposFavoritosDTO> dtoLista = new ArrayList<>();
        for(String[] columna:filaLista){
            EquiposFavoritosDTO dto = new EquiposFavoritosDTO();
            dto.setNameteam(columna[0]);
            dto.setNameligue(columna[1]);
            dto.setYear(Integer.parseInt(columna[2]));
            dto.setNamecountry(columna[3]);
            dtoLista.add(dto);
        }
        return dtoLista;
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