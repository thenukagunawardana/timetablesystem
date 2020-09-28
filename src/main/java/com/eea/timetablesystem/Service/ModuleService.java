package com.eea.timetablesystem.Service;

import com.eea.timetablesystem.Model.Modules;

import java.util.List;

public interface ModuleService
{
    List<Modules>getAllModules(String keyword);
    void addModule(Modules modules);
    Modules getModuleById(int id);
    void deleteModuleById(int id);

}
