package org.example.gekobetv1.controllers;

import org.example.gekobetv1.dtos.LigueDTO;
import org.example.gekobetv1.dtos.QueryLigueLiguesXSeasonXTempDTO;
import org.example.gekobetv1.dtos.QueryTeamEquiposFavXPaisDTO;
import org.example.gekobetv1.dtos.UserDTO;
import org.example.gekobetv1.entities.Ligue;
import org.example.gekobetv1.entities.User;
import org.example.gekobetv1.servicesinterfaces.ILigueService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ligues")
public class LigueController {
    @Autowired
    private ILigueService lS;
    @PostMapping
    public void registrar(@RequestBody LigueDTO l){
        ModelMapper m=new ModelMapper();
        Ligue li = m.map(l, Ligue.class);
        lS.insert(li);
    }
    @GetMapping
    public List<LigueDTO> list(){
        return lS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,LigueDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/Ligas_x_Tempo_Pais/{anio_ingresado}/{pais_ingresado}")
    public List<QueryLigueLiguesXSeasonXTempDTO> ligas_season_country(@PathVariable("anio_ingresado") int anio_ingresado,
                                                                        @PathVariable("pais_ingresado") String pais_ingresado){
        List<String[]> filaLista= lS.listaLigasxSeasonCountry(anio_ingresado,pais_ingresado);
        List<QueryLigueLiguesXSeasonXTempDTO> dtoLista = new ArrayList<>();
        for(String[] columna:filaLista){
            QueryLigueLiguesXSeasonXTempDTO dto = new QueryLigueLiguesXSeasonXTempDTO();
            dto.setNameligue(columna[0]);
            dto.setYear(Integer.parseInt(columna[1]));
            dto.setNamecountry(columna[2]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }
    @PutMapping
    public void Editar(@RequestBody LigueDTO l){
        ModelMapper m=new ModelMapper();
        Ligue li = m.map(l,Ligue.class);
        lS.insert(li);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        lS.delete(id);
    }

}