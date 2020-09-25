package com.eea.timetablesystem.Service;


import com.eea.timetablesystem.Model.Modules;
import com.eea.timetablesystem.Repository.ModulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleServiceImpl implements ModuleService
{
    @Autowired
    private ModulesRepository modulesRepository;

    @Override
    public List<Modules> getAllModules() {
        return modulesRepository.findAll();
    }

    @Override
    public void addModule(Modules modules)
    {
        this.modulesRepository.save(modules);
    }

    @Override
    public Modules getModuleById(int id)
    {
        Optional<Modules> optional=modulesRepository.findById(id);
        Modules modules=null;
        if (optional.isPresent())
        {
            modules=optional.get();
        }
        else
        {
            throw new RuntimeException("Module Not Found for ID: "+id);

        }

        return modules;
    }

    @Override
    public void deleteModuleById(int id)
    {
        this.modulesRepository.deleteById(id);

    }
}
