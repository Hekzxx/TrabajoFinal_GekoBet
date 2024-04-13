package org.example.gekobetv1.repositories;

import org.example.gekobetv1.entities.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFavoriteRepository extends JpaRepository<Favorite,Integer> {
}