package org.example.gekobetv1.servicesimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.gekobetv1.entities.User;
import org.example.gekobetv1.repositories.IUserRepository;
import org.example.gekobetv1.servicesinterfaces.IUserService;

import java.util.List;
@Service
public class UserServiceImplement implements IUserService{
    @Autowired
    private IUserRepository uR;
    @Override
    public void insert(User user) {
        uR.save(user);
    }

    @Override
    public List<User> list() {
        return uR.findAll();
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    @Override
    public User listId(int id) {
        return uR.findById(id).orElse(new User());
    }
    @Override
    public List<User> findByDni(Integer dni) {
        return uR.findByDni(dni);
    }
}
