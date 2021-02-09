package com.eea.timetablesystem.Repository;

import com.eea.timetablesystem.Model.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TimeTableRepository extends JpaRepository<TimeTable,Integer>
{
    @Query("SELECT a FROM TimeTable a WHERE a.batchCode LIKE %?1%")
     List<TimeTable> findAll(String keyword);
}
