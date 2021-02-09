package com.eea.timetablesystem.Service;

import com.eea.timetablesystem.Model.TimeTable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TimeTableService
{
    void addTimeTable(TimeTable timeTable);

    List<TimeTable>getAllTimeTables(String keyword);

    TimeTable getTimeTableById(int id);

    void deleteTimeTableById(int id);

}
