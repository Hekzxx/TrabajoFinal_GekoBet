package org.example.gekobetv1.repositories;

import org.example.gekobetv1.entities.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ISeasonRepository extends JpaRepository<Season,Integer> {

}