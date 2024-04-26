package org.example.gekobetv1.servicesinterfaces;

import org.example.gekobetv1.entities.Role;

import java.util.List;

public interface IRoleService {

    public void insert(Role role);
    public List<Role> list();
    public void delete(int id);
    public Role listId(int id);
}