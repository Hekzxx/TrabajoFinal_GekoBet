package org.example.gekobetv1.repositories;
import org.example.gekobetv1.entities.TeamXMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeamXMatchRepository extends JpaRepository<TeamXMatch,Integer> {
}
