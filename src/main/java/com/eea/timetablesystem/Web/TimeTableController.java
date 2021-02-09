package com.eea.timetablesystem.Web;


import com.eea.timetablesystem.Model.Modules;
import com.eea.timetablesystem.Model.TimeTable;
import com.eea.timetablesystem.Service.TimeTableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TimeTableController
{
    @Autowired
    private TimeTableService timeTableService;

    @GetMapping("/timetable")
    public String timetable(Model model, @Param("keyword")String keyword)
    {
        List<TimeTable>listTimeTable=timeTableService.getAllTimeTables(keyword);
        model.addAttribute("listTimeTable",timeTableService.getAllTimeTables(keyword));
        model.addAttribute("keyword",keyword);

        return "timetable";
    }

    @GetMapping("/addTimeTable")
    public String addTimeTable(Model model)
    {
        TimeTable timeTable= new TimeTable();
        model.addAttribute("timetable",timeTable);
        return "addTimeTable";
    }

    @PostMapping("/addTimeTable")
    public String addTimeTable(@ModelAttribute("timetable")TimeTable timeTable)
    {
        timeTableService.addTimeTable(timeTable);
        return "redirect:/timetable";

    }
    @GetMapping("/updateTimetable/{id}")
    public String showFormForUpdateTimeTable(@PathVariable(value = "id")int id,Model model)
    {
        TimeTable timeTable=timeTableService.getTimeTableById(id);

        model.addAttribute("timetable",timeTable);
        return "updateTimetable";
    }

    @GetMapping("/deleteTimeTable/{id}")
    public String deleteTimeTable(@PathVariable(value = "id") int id)
    {
        this.timeTableService.deleteTimeTableById(id);
        return "redirect:/timetable";
    }
}
