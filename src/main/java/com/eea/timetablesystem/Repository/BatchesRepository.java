package com.eea.timetablesystem.Repository;

import com.eea.timetablesystem.Model.Batches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BatchesRepository extends JpaRepository<Batches,Integer>
{
    @Query("SELECT p FROM Batches p WHERE p.batchCode LIKE %?1%")
    List<Batches> findAll(String keyword);
}
