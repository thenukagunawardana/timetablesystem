package com.eea.timetablesystem.Service;

import com.eea.timetablesystem.DTO.UserRegistrationDto;
import com.eea.timetablesystem.Model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService
{

    User save(UserRegistrationDto registrationDto);

    List<User>getAllUsers(String keyword);

    void deleteUserById(int id);
}
