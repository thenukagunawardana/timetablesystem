package com.eea.timetablesystem.Repository;

import com.eea.timetablesystem.Model.Batches;
import com.eea.timetablesystem.Model.ClassRooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassRoomRepository extends JpaRepository<ClassRooms,Integer>
{
    @Query("SELECT p FROM ClassRooms p WHERE p.className LIKE %?1%")
    List<ClassRooms> findAll(String keyword);
}
