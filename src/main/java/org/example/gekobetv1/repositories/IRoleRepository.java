package org.example.gekobetv1.repositories;

import org.example.gekobetv1.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IRoleRepository extends JpaRepository<Role,Integer> {
}