package com.eea.timetablesystem.Service;

import com.eea.timetablesystem.Model.Batches;

import java.util.List;

public interface BatchesService
{
    List<Batches>getAllBatches(String keyword);
    void addBatch(Batches batches);
    Batches getBatchById(int id);
    void deleteBatchesById(int id);
}
