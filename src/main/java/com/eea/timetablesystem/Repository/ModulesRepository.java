package com.eea.timetablesystem.Repository;

import com.eea.timetablesystem.Model.Modules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModulesRepository extends JpaRepository<Modules,Integer>
{
    @Query("SELECT p FROM Modules p WHERE p.module_name LIKE %?1%")
    List<Modules> findAll(String keyword);
}
