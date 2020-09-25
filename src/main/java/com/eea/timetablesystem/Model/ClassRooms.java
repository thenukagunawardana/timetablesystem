package com.eea.timetablesystem.Model;


import javax.persistence.*;

@Entity
@Table(name = "classroom",uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class ClassRooms
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String className;

    public ClassRooms(String className)
    {
        this.className = className;
    }

    public ClassRooms()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
