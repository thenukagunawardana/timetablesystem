package com.eea.timetablesystem.Model;

import javax.persistence.*;

@Entity
@Table(name="modules", uniqueConstraints = {

@UniqueConstraint(columnNames = "id")
})
public class Modules
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String module_name;

    public Modules(String module_name)
    {
        this.module_name = module_name;
    }

    public Modules()
    {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }
}
