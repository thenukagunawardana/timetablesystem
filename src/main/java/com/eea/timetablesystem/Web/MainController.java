package com.eea.timetablesystem.Web;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController
{
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    @GetMapping("/")
    public String home()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("Admin")||r.getAuthority().equals("admin")))
        {
            return "redirect:/adminHomePage";
        }
        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("Student")||r.getAuthority().equals("student")))
        {
            return "redirect:/studentHomePage";
        }
        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("Lecturer")||r.getAuthority().equals("lecturer")))
        {
            return "redirect:/lecturerHomePage";
        }
        return "index";
    }

    @GetMapping("/adminHomePage")
    private String adminHomePage()
    {
        return "index";
    }

    @GetMapping("/studentHomePage")
    private String studentHomePage()
    {
        return "studentHomePage";
    }

    @GetMapping("/lecturerHomePage")
    private String lecturerHomePage()
    {
        return "lecturerHomePage";
    }
}
