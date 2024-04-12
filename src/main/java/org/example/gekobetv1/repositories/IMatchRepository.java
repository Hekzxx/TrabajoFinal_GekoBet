package org.example.gekobetv1.repositories;

import org.example.gekobetv1.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMatchRepository extends JpaRepository<Match,Integer> {
}
