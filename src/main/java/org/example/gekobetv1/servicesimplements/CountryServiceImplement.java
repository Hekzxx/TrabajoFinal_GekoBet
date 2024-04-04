package org.example.gekobetv1.servicesimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.gekobetv1.entities.Country;
import org.example.gekobetv1.repositories.ICountryRepository;
import org.example.gekobetv1.servicesinterfaces.ICountryService;
import java.util.List;
@Service
public class CountryServiceImplement implements ICountryService{
    @Autowired
    private ICountryRepository cR;
    @Override
    public void insert(Country country) {
        cR.save(country);
    }

    @Override
    public List<Country> list() {
        return cR.findAll();
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public Country listId(int id) {
        return cR.findById(id).orElse(new Country());
    }
}
