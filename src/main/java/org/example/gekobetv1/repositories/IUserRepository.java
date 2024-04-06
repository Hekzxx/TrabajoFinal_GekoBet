package org.example.gekobetv1.repositories;

import org.example.gekobetv1.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.example.gekobetv1.entities.User;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {
    public List<User> findByDni(String dni);
}
