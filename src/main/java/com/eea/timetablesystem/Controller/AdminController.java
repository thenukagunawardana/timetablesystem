/*
package com.eea.timetablesystem.Controller;

import com.eea.timetablesystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    UserService userService;


    @GetMapping("loadHome")
    public String loadHome(Model model)
    {
        model.addAttribute("users",userService
        .getAll());

    }
}
*/
