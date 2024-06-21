package org.example.gekobetv1.controllers;
import org.example.gekobetv1.dtos.*;
import org.example.gekobetv1.entities.Team;
import org.example.gekobetv1.servicesinterfaces.ITeamService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teams")
//@PreAuthorize("hasAuthority('ADMIN')")
public class TeamController {
    @Autowired
    private ITeamService tS;
    @PostMapping
    public void registrar(@RequestBody TeamDTO t){
        ModelMapper m=new ModelMapper();
        Team te = m.map(t, Team.class);
        tS.insert(te);
    }
    @GetMapping
    public List<TeamDTO> list(){
        return tS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,TeamDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/Equipos_Temporada_Actual")
    public List<QueryTeamCantEquipoTempActualDTO> equipos_temporada_actual(){
        List<String[]> filaLista= tS.cantEquipoTemporadaActual();
        List<QueryTeamCantEquipoTempActualDTO> dtoLista = new ArrayList<>();
        for(String[] columna:filaLista){
            QueryTeamCantEquipoTempActualDTO dto = new QueryTeamCantEquipoTempActualDTO();
            dto.setCantidad_equipo_temporada(Integer.parseInt(columna[0]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/Equipos_Favoritos_X_Pais/{pais_ingresado}/{id_usuario}")
    public List<QueryTeamEquiposFavXPaisDTO> equipos_favoritos_pais(@PathVariable("pais_ingresado") String pais_ingresado,
                                                                    @PathVariable("id_usuario") int id_usuario){
        List<String[]> filaLista= tS.listaEquipoFavoritoXPais(pais_ingresado,id_usuario);
        List<QueryTeamEquiposFavXPaisDTO> dtoLista = new ArrayList<>();
        for(String[] columna:filaLista){
            QueryTeamEquiposFavXPaisDTO dto = new QueryTeamEquiposFavXPaisDTO();
            dto.setNameteam(columna[0]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @PutMapping
    public void Editar(@RequestBody TeamDTO t){
        ModelMapper m=new ModelMapper();
        Team te = m.map(t,Team.class);
        tS.insert(te);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        tS.delete(id);
    }

    @GetMapping("/{id}")
    public TeamDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        TeamDTO dto=m.map(tS.listId(id),TeamDTO.class);
        return dto;
    }

}