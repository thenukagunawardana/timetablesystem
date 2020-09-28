package com.eea.timetablesystem.Web;


import com.eea.timetablesystem.Model.Modules;
import com.eea.timetablesystem.Service.ModuleService;
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
public class ModulesController
{
    @Autowired
    private ModuleService moduleService;

    @GetMapping("/modules")
    public String modules(Model model, @Param("keyword")String keyword)
    {
        List<Modules>listModules=moduleService.getAllModules(keyword);
        model.addAttribute("listModules",moduleService.getAllModules(keyword));
        model.addAttribute("keyword",keyword);
        return "modules";
    }

    @GetMapping("/addModules")
    public String addModules(Model model)
    {
        Modules modules=new Modules();
        model.addAttribute("modules",modules);
        return "addModules";
    }
    @PostMapping("/addModules")
    public String addModules(@ModelAttribute("modules")Modules modules)
    {
        moduleService.addModule(modules);
        return "redirect:/modules";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id")int id,Model model)
    {
        Modules modules=moduleService.getModuleById(id);
        model.addAttribute("modules",modules);
        return "updateModules";
    }

    @GetMapping("/deleteModule/{id}")
    public String deleteModule(@PathVariable(value = "id") int id)
    {
        this.moduleService.deleteModuleById(id);
        return "redirect:/modules";
    }

}
