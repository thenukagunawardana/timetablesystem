package com.eea.timetablesystem.Web;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("Admin")))
        {
            return "redirect:/adminHomePage";
        }
        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("Student")))
        {
            return "redirect:/studentHomePage";
        }
        return "index";
    }

    @GetMapping("/adminHomePage")
    private String adminHomePage()
    {
        return "index";
    }

    @GetMapping("/userHomePage")
    private String userHomePage()
    {
        return "userHome";
    }
}
