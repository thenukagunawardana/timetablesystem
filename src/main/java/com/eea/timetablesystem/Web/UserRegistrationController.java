package com.eea.timetablesystem.Web;


import com.eea.timetablesystem.DTO.AdminRegistrationDto;
import com.eea.timetablesystem.DTO.UserRegistrationDto;
import com.eea.timetablesystem.Model.Admin;
import com.eea.timetablesystem.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }

    @GetMapping("/registerAdmin")
    public String loadAdmin(Model model)
    {
        model.addAttribute("admin",new AdminRegistrationDto());
        return "RegisterAdmin";
    }

    @PostMapping("/saveAdmin")
    public String saveAdmin(@ModelAttribute("admin")AdminRegistrationDto adminRegistrationDto)
    {
        Admin savedAdmin=admin
    }
}
