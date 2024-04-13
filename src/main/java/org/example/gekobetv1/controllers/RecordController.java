package org.example.gekobetv1.controllers;
import org.example.gekobetv1.entities.Record;
import org.example.gekobetv1.dtos.MatchDTO;
import org.example.gekobetv1.dtos.RecordDTO;
import org.example.gekobetv1.servicesinterfaces.IRecordService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Records")
public class RecordController {
    @Autowired
    private IRecordService rS;
    @PostMapping
    public void registrar(@RequestBody RecordDTO r){
        ModelMapper m=new ModelMapper();
        Record re = m.map(r, Record.class);
        rS.insert(re);
    }
    @GetMapping
    public List<RecordDTO> list(){
        return rS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,RecordDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        rS.delete(id);
    }
    @GetMapping("/{id}")
    public RecordDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        RecordDTO dto=m.map(rS.listId(id),RecordDTO.class);
        return dto;
    }
}
