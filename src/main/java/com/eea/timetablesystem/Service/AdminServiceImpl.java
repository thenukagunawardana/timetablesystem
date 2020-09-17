package com.eea.timetablesystem.Service;

import com.eea.timetablesystem.DTO.AdminRegistrationDto;
import com.eea.timetablesystem.Model.Admin;

public interface AdminServiceImpl
{
    public void save(Admin saveAdmin);
    public Admin saveAdmin(AdminRegistrationDto adminRegistrationDto);


}
