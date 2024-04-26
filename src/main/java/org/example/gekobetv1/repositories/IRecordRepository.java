package org.example.gekobetv1.repositories;
import org.example.gekobetv1.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecordRepository extends JpaRepository<Record,Integer> {
}