package com.eea.timetablesystem.Service;


import com.eea.timetablesystem.DTO.AdminRegistrationDto;
import com.eea.timetablesystem.Model.Admin;
import com.eea.timetablesystem.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService
{
    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin saveAdmin(AdminRegistrationDto adminRegistrationDto)
    {
        Admin admin=new Admin();
        admin.setFirstName(adminRegistrationDto.getFirstName());
        admin.setLastName(adminRegistrationDto.getLastName());
        admin.setUsername(adminRegistrationDto.getUsername());
        admin.setPhoneNumber(adminRegistrationDto.getPhoneNumber());
        admin.setNIC(adminRegistrationDto.getNIC());
        return adminRepository.save(admin);

    }
    @Override
    public void save(Admin saveAdmin )
    {
        adminRepository.save(saveAdmin);
    }
}
