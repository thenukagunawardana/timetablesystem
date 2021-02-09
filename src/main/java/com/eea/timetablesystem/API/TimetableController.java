package com.eea.timetablesystem.API;

import com.eea.timetablesystem.DTO.UserRegistrationDto;
import com.eea.timetablesystem.Model.*;
import com.eea.timetablesystem.Repository.*;
import com.eea.timetablesystem.Service.BatchesService;
import com.eea.timetablesystem.Service.ClassRoomService;
import com.eea.timetablesystem.Service.ModuleService;
import com.eea.timetablesystem.Service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("timetableSystemAPI/version/")
public class TimetableController
{
    @Autowired
    public ClassRoomRepository classroomRepository;

    @Autowired
    public ClassRoomService classroomService;

    @Autowired
    public ModuleService moduleService;

    @Autowired
    private TimeTableRepository timetableRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BatchesRepository batchRepository;

    @Autowired
    private ModulesRepository moduleRepository;

    @Autowired
    public BatchesService batchService;

    @Autowired
    private UserService userService;


    //View ALL Timetables
    @GetMapping("/timetables")
    public List<TimeTable> viewTimetables()
    {
        return timetableRepository.findAll();
    }


    //View All Users
    @GetMapping("/users")
    public List<User> viewUsers() {
        return userRepository.findAll();
    }


    //View All Batches
    @GetMapping("/batches")
    public List<Batches> viewBatches() {
        return batchRepository.findAll();
    }


    //View All Modules
    @GetMapping("/modules")
    public List<Modules> viewModules() {
        return moduleRepository.findAll();
    }

    //Login Method

    @GetMapping("/login/{username}/{password}")
    public JSONObject login(@PathVariable(value = "username") String username,
                            @PathVariable(value = "password") String password)
    {
        JSONObject obj = new JSONObject();
        User user = new User();
        user = userRepository.findByEmail(username);
        String pass = user.getPassword();
        if (user != null)
        {
            if (userService.passwordencode(password, pass))
            {

                obj.put("user", user);
                obj.put("Response", "Correct");
                obj.put("Role", user.getRoles());
                return obj;
            }
            else
            {
                obj.put("Response", "Wrong");
                return obj;
            }
        }
        else
        {
            obj.put("Response", "Error");
            return obj;
        }
    }

    //Add new Batch Method
    @PostMapping("admin/saveBatch")
    public JSONObject saveBatch(@RequestBody Batches batch){
        JSONObject obj = new JSONObject();

        batchService.addBatch(batch);

        obj.put("Response", "Success");
        return obj;
    }


    //Add Classroom Method
    @PostMapping("admin/saveClassroom")
    public JSONObject saveClassroom(@RequestBody ClassRooms classroom){
        JSONObject obj = new JSONObject();

        classroomService.addClass(classroom);

        obj.put("Response", "Success");
        return obj;
    }


    //Add Module Method
    @PostMapping("admin/saveModule")
    public JSONObject saveModule(@RequestBody Modules module){
        JSONObject obj = new JSONObject();

        moduleService.addModule(module);

        obj.put("Response", "Success");
        return obj;
    }


    //Register User
    @PostMapping("/register")
    public JSONObject RegisterUser(@RequestBody UserRegistrationDto user)
    {
        JSONObject obj = new JSONObject();

        userService.save(user);

        obj.put("Response", "Success");
        return obj;
    }

}
