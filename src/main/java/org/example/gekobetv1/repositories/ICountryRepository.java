package org.example.gekobetv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.example.gekobetv1.entities.Country;
import java.util.List;
@Repository
public interface ICountryRepository extends JpaRepository<Country,Integer>{

}