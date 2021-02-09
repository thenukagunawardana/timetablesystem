package com.eea.timetablesystem.Model;


import javax.persistence.*;

@Entity
@Table(name="timetable", uniqueConstraints =
        {
       @UniqueConstraint(columnNames = "id")
})
public class TimeTable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String batchCode;
    private String moduleName;
    private String classRoom;
    private String lecturer;
    private String time;
    private String date;

    public TimeTable()
    {

    }

    public TimeTable(String batchCode, String moduleName, String classRoom, String lecturer, String time, String date)
    {
        this.batchCode = batchCode;
        this.moduleName = moduleName;
        this.classRoom = classRoom;
        this.lecturer = lecturer;
        this.time = time;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
