package com.eea.timetablesystem.Service;

import com.eea.timetablesystem.DTO.UserRegistrationDto;
import com.eea.timetablesystem.Model.User;
import org.springframework.security.core.userdetails.UserDetailsService;



public interface UserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);
}
