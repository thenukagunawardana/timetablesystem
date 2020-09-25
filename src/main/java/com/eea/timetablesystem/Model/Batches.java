package com.eea.timetablesystem.Model;


import javax.persistence.*;

@Entity
@Table(name="batches",uniqueConstraints =
        {
            @UniqueConstraint(columnNames = "id")
        })
public class Batches
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String batchCode;

    public Batches(String batchCode) {
        this.batchCode = batchCode;
    }

    public Batches()
    {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode)
    {
        this.batchCode = batchCode;
    }
}
