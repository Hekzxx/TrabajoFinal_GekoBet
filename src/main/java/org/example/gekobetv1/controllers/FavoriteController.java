package org.example.gekobetv1.controllers;

import org.example.gekobetv1.dtos.*;
import org.example.gekobetv1.entities.Favorite;
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
//@PreAuthorize("hasAuthority('USER')")
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
    public List<QueryFavoriteEquiposFavoritosDTO> equiposFavoritos(@PathVariable("id_usuario") String id_usuario){
        List<String[]> filaLista= fS.listaEquipoFavorito(Integer.parseInt(id_usuario));
        List<QueryFavoriteEquiposFavoritosDTO> dtoLista = new ArrayList<>();
        for(String[] columna:filaLista){
            QueryFavoriteEquiposFavoritosDTO dto = new QueryFavoriteEquiposFavoritosDTO();
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
        FavoriteDTO dto=m.map(fS.listID(id),FavoriteDTO.class);
        return dto;
    }

    @GetMapping("/listar/{id}")
    public List<FavoriteDTO> ListarFavoritosPorUsuario(@PathVariable("id") Integer id){
        return fS.ListaFavoritosPorUsuarioId(id).stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,FavoriteDTO.class);
        }).collect(Collectors.toList());
    }


}