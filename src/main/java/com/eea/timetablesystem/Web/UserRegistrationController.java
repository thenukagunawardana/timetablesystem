package com.eea.timetablesystem.Web;


import com.eea.timetablesystem.DTO.UserRegistration;
import com.eea.timetablesystem.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController
{
    private UserService userService;

    public UserRegistrationController(UserService userService)
    {
        super();
        this.userService=userService;
    }

    @GetMapping
    public String showRegistrationForm()
    {
        return "registration";
    }

    @PostMapping
    public String registeredUserAccount(@ModelAttribute("user")UserRegistration registration)
    {
        userService.save(registration);
        return "redirect:/registration?success";
    }
}
