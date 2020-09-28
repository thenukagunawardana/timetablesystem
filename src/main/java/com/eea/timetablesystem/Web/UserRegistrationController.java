package com.eea.timetablesystem.Web;


import com.eea.timetablesystem.DTO.UserRegistrationDto;
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

    private final UserService userService;


//    private AdminService adminService;

    public UserRegistrationController(UserService userService)
    {
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

    @GetMapping("/")
    public String viewHomePage(Model model)
    {
        model.addAttribute("listUser",userService.getAllUsers());
        return "index";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }

//    @GetMapping("/registerAdmin")
//    public String saveAdmin(Model model)
//    {
//        model.addAttribute("admin",new AdminRegistrationDto());
//        return "RegisterAdmin";
//    }
//    @PostMapping("/saveAdmin")
//    public String saveAdmin(@ModelAttribute("admin")AdminRegistrationDto adminRegistrationDto)
//    {
//
//        Admin savedAdmin = adminService.saveAdmin(adminRegistrationDto);
//        User user = new User();
//        user.setFirstName(adminRegistrationDto.getFirstName());
//        user.setLastName(adminRegistrationDto.getLastName());
////        user.(adminRegistrationDto.get());
//
//        return "redirect:/user/registerAdmin?success";
//    }

}
