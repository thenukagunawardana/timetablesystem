package com.eea.timetablesystem.Repository;

import com.eea.timetablesystem.Model.ClassRooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRoomRepository extends JpaRepository<ClassRooms,Integer>
{

}
