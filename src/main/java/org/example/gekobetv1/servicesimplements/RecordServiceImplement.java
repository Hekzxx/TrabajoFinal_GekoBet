package org.example.gekobetv1.servicesimplements;
import org.example.gekobetv1.entities.Record;
import org.example.gekobetv1.repositories.IRecordRepository;
import org.example.gekobetv1.servicesinterfaces.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImplement implements IRecordService {
    @Autowired
    private IRecordRepository rR;
    @Override
    public void insert(Record record) {
        rR.save(record);
    }

    @Override
    public List<Record> list() { return rR.findAll(); }

    @Override
    public List<String[]> cantVictoriasEquipoFavorito(int id_usuario) {
        return rR.cantVictoriasEquipoFavorito(id_usuario);
    }

    @Override
    public void delete(int id) { rR.deleteById(id); }

    @Override
    public Record listId(int id) {
        return rR.findById(id).orElse(new Record());
    }
}