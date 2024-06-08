package org.example.gekobetv1.servicesinterfaces;

import org.example.gekobetv1.entities.Record;

import java.util.List;

public interface IRecordService {
    public void insert(Record record);
    public List<Record> list();
    public List<String[]> cantVictoriasEquipoFavorito(int id_usuario);
    public void delete(int id);
    public Record listId(int id);
}