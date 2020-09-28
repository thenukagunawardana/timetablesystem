package com.eea.timetablesystem.Web;


import com.eea.timetablesystem.Model.ClassRooms;
import com.eea.timetablesystem.Service.ClassRoomService;
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
public class ClassRoomController
{
    @Autowired
    private ClassRoomService classRoomService;

    @GetMapping("/classRooms")
    public String viewHomePage(Model model, @Param("keyword")String keyword)
    {
        List<ClassRooms>listClasses=classRoomService.getAllClassRooms(keyword);
        model.addAttribute("listClasses",classRoomService.getAllClassRooms(keyword));
        model.addAttribute("keyword",keyword);
        return "classRooms";
    }

    @GetMapping("/addClassRoom")
    public String addNewClassRoom(Model model){
        ClassRooms classRooms = new ClassRooms();
        model.addAttribute("classRooms",classRooms);
        return "addClassRoom";

    }

    @PostMapping("/addClassRoom")
    public String addClassRoom(@ModelAttribute("classRooms")ClassRooms classRooms){
        classRoomService.addClass(classRooms);
        return "redirect:/classRooms";
    }

    @GetMapping("/showFormForUpdateClassRoom/{id}")
    public String showFormForUpdateClassRoom(@PathVariable(value = "id")int id, Model model){
        //Get module from the service
        ClassRooms classRooms=classRoomService.getClassById(id);

        model.addAttribute("classRooms",classRooms);
        return "updateClassRoom";
    }

    @GetMapping("/deleteClassRoom/{id}")
    public String deleteClassRoom(@PathVariable(value = "id")int id){
        this.classRoomService.deleteClassById(id);
        return "redirect:/classRooms";

    }
}
