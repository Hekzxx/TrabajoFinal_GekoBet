package org.example.gekobetv1.servicesinterfaces;
import org.example.gekobetv1.entities.User;

import java.util.List;
public interface IUserService {
    public void insert(User user);
    public List<User> list();
    public void delete(int id);
    public User listId(int id);
    public List<User> findByDni(String dni);
}
