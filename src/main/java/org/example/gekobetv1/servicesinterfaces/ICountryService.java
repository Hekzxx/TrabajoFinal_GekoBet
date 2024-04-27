package org.example.gekobetv1.servicesinterfaces;
import org.example.gekobetv1.entities.Country;
import java.util.List;

public interface ICountryService {
    public void insert(Country country);
    public List<Country> list();
    public void delete(int id);
}