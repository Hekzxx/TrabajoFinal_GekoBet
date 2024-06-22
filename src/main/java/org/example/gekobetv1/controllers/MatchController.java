package org.example.gekobetv1.controllers;
import org.example.gekobetv1.dtos.*;
import org.example.gekobetv1.entities.Match;
import org.example.gekobetv1.entities.Team;
import org.example.gekobetv1.servicesinterfaces.IMatchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Matches")
public class MatchController {
    @Autowired
    private IMatchService mS;
    @PostMapping
    //@PreAuthorize("hasAuthority('ADMIN')")
    public void registrar(@RequestBody MatchDTO mt){
        ModelMapper m=new ModelMapper();
        Match ma = m.map(mt, Match.class);
        mS.insert(ma);
    }
    @GetMapping
    //@PreAuthorize("hasAuthority('ADMIN')")
    public List<MatchDTO> list(){
        return mS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,MatchDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/Partidos_por_temporada/{anio_ingresado}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public List<QueryMatchPartidosXTemporadaDTO> cantidadPartidosTemporada(@PathVariable("anio_ingresado") int anio_ingresado){
        List<String[]> filaLista= mS.cantidadPartidosXTemporada(anio_ingresado);
        List<QueryMatchPartidosXTemporadaDTO> dtoLista = new ArrayList<>();
        for(String[] columna:filaLista){
            QueryMatchPartidosXTemporadaDTO dto = new QueryMatchPartidosXTemporadaDTO();
            dto.setCantidad_partidos(Integer.parseInt(columna[0]));

            dtoLista.add(dto);
        }
        return dtoLista;
    }
    @GetMapping("/Partidos_por_liga/{liga_ingresada}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public List<QueryMatchMatchXLeagueDTO> PartidosLiga(@PathVariable("liga_ingresada") String liga_ingresada){
        List<String[]> filaLista= mS.PartidosXLiga(liga_ingresada);
        List<QueryMatchMatchXLeagueDTO> dtoLista = new ArrayList<>();
        for(String[] columna:filaLista){
            QueryMatchMatchXLeagueDTO dto = new QueryMatchMatchXLeagueDTO();
            dto.setCantidad_partidos_jugados(Integer.parseInt(columna[0]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
    @GetMapping("/Equipos_Temporada/{anio_ingresada}")
    //@PreAuthorize("hasAuthority('USER')")
    public List<QueryMatchEquipoXTempDTO> PartidosLiga(@PathVariable("anio_ingresada") int anio_ingresada){
        List<String[]> filaLista= mS.EquiposxTempo(anio_ingresada);
        List<QueryMatchEquipoXTempDTO> dtoLista = new ArrayList<>();
        for(String[] columna:filaLista){
            QueryMatchEquipoXTempDTO dto = new QueryMatchEquipoXTempDTO();
            dto.setNameteam(columna[0]);
            dto.setYear(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/ProbabilidadEquipo/{teamrecord}/{idmatchingresado}")
    public float ProbabilidadEquipo(@PathVariable("teamrecord") int teamrecord,
                                    @PathVariable("idmatchingresado") int idmatchingresado){
        return mS.ProbabilidadEquipo(teamrecord,idmatchingresado);
    }
    @GetMapping("/GolesdeEquipo/{idteam}")
    public float GolesdeEquipo(@PathVariable("idteam") int idteam){
        return mS.ObtenerGolesdeEquipo(idteam);
    }

    @GetMapping("/EquiposSegunPartido/{idm}")
    public List<QueryMatchObtenerEquipoSegunPartidoDTO> EquiposSegunPartido(@PathVariable("idm") int idm){
        List<String[]> filaLista= mS.ObtenerEquipoSegunPartido(idm);
        List<QueryMatchObtenerEquipoSegunPartidoDTO> dtoLista = new ArrayList<>();
        for(String[] columna:filaLista){
            QueryMatchObtenerEquipoSegunPartidoDTO dto = new QueryMatchObtenerEquipoSegunPartidoDTO();
            dto.setNombreEQUIPO(columna[0]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @PutMapping
    //@PreAuthorize("hasAuthority('ADMIN')")
    public void Editar(@RequestBody MatchDTO mt){
        ModelMapper m=new ModelMapper();
        Match ma = m.map(mt,Match.class);
        mS.insert(ma);
    }
    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        mS.delete(id);
    }

    @GetMapping("/{id}")
    public MatchDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        MatchDTO dto=m.map(mS.listId(id),MatchDTO.class);
        return dto;
    }

    @GetMapping("/last")
    public int UltimoMatchCreado(){
        return mS.UltimoMatchCreado();
    }

}