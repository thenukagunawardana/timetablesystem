package com.eea.timetablesystem.Service;

import com.eea.timetablesystem.Model.TimeTable;
import com.eea.timetablesystem.Repository.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeTableServiceImpl implements TimeTableService
{
    @Autowired
    private TimeTableRepository timeTableRepository;

    @Override
    public void addTimeTable(TimeTable timeTable)
    {
        this.timeTableRepository.save(timeTable);

    }

    @Override
    public List<TimeTable> getAllTimeTables(String keyword)
    {
        if (keyword!=null)
        {
            return timeTableRepository.findAll(keyword);
        }
        return timeTableRepository.findAll();
    }

    @Override
    public TimeTable getTimeTableById(int id)
    {
        Optional <TimeTable> optional=timeTableRepository.findById(id);
        TimeTable timeTable=null;
        if (optional.isPresent())
        {
            timeTable=optional.get();

        }
        else
        {
            throw new RuntimeException("TimeTable Not Found "+id);

        }
        return timeTable;
    }

    @Override
    public void deleteTimeTableById(int id)
    {
        this.timeTableRepository.deleteById(id);
    }
}
