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

}