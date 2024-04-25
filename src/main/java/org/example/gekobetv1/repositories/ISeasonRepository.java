package org.example.gekobetv1.repositories;

import org.example.gekobetv1.entities.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ISeasonRepository extends JpaRepository<Season,Integer> {

}