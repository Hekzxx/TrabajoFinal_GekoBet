package org.example.gekobetv1.servicesimplements;

import org.example.gekobetv1.entities.Role;
import org.example.gekobetv1.repositories.IRoleRepository;
import org.example.gekobetv1.servicesinterfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImplement implements IRoleService {
    @Autowired
    private IRoleRepository rR;
    @Override
    public void insert(Role role) {
        rR.save(role);
    }

    @Override
    public List<Role> list() { return rR.findAll(); }

    @Override
    public void delete(int id) { rR.deleteById(id); }

    @Override
    public Role listId(int id) {
        return rR.findById(id).orElse(new Role());
    }
    @Override
    public List<Role> findByTipo(String tipo) {
        return rR.findByTipo(tipo);
    }
}
