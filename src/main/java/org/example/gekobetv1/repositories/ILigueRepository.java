package org.example.gekobetv1.repositories;
import org.example.gekobetv1.entities.Ligue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ILigueRepository extends JpaRepository<Ligue,Integer> {

}