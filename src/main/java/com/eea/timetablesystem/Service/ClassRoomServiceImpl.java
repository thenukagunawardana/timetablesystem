package com.eea.timetablesystem.Service;


import com.eea.timetablesystem.Model.ClassRooms;
import com.eea.timetablesystem.Repository.ClassRoomRepository;
import jdk.nashorn.internal.ir.Optimistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassRoomServiceImpl implements ClassRoomService
{
    @Autowired
    private ClassRoomRepository classRoomRepository;


    @Override
    public List<ClassRooms> getAllClassRooms(String keyword)
    {
        if (keyword!=null)
        {
            return classRoomRepository.findAll(keyword);
        }
        return classRoomRepository.findAll();
    }

    @Override
    public void addClass(ClassRooms classRooms) {
        this.classRoomRepository.save(classRooms);
    }

    @Override
    public ClassRooms getClassById(int id) {
        Optional<ClassRooms> optional=classRoomRepository.findById(id);
        ClassRooms classRooms=null;
        if (optional.isPresent())
        {
            classRooms=optional.get();
        }
        else
            {
                throw new RuntimeException("ClassRoom Not Found"+id);

        }
        return classRooms;
    }

    @Override
    public void deleteClassById(int id) {
        this.classRoomRepository.deleteById(id);

    }
}
