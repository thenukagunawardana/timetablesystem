package com.eea.timetablesystem.Service;

import com.eea.timetablesystem.Model.ClassRooms;

import java.util.List;

public interface ClassRoomService
{
    List<ClassRooms> getAllClassRooms(String keyword);
    void addClass(ClassRooms classRooms);
    ClassRooms getClassById(int id);
    void deleteClassById(int id);
}
