package org.example.gekobetv1.servicesinterfaces;

import org.example.gekobetv1.entities.Role;
import org.example.gekobetv1.repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IRoleService {

    public void insert(Role role);
    public List<Role> list();
    public void delete(int id);
    public Role listId(int id);
    public List<Role> findByTipo(String tipo);
}
