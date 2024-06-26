package org.example.gekobetv1.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.example.gekobetv1.entities.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {

    public User findByUsername(String username);

    //BUSCAR POR NOMBRE
    @Query("select count(u.username) from User u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);


    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, idUser) VALUES (:rol, :idUser)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("idUser") Long idUser);

    @Query(value = "SELECT u.* from usuario u where u.id = :id_usuario", nativeQuery = true)
    public List<User> ListarUsuariosPorId(int id_usuario);

    @Query(value = "select distinct u.id from usuario u\n" +
            "where u.username = :username", nativeQuery = true)
    public int idUsername(String username);

    @Query(value = "select id from usuario order by id desc limit 1", nativeQuery = true)
    public int ultimousuariocreado();
}