package com.eea.timetablesystem.Repository;

import com.eea.timetablesystem.Model.Modules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModulesRepository extends JpaRepository<Modules,Integer>
{

}
