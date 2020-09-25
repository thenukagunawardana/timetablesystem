package com.eea.timetablesystem.Service;

import com.eea.timetablesystem.Model.Batches;
import org.hibernate.engine.jdbc.batch.spi.Batch;

import java.util.List;

public interface BatchesService
{
    List<Batches>getAllBatches();
    void addBatch(Batches batches);
    Batches getBatchById(int id);
    void deleteBatchesById(int id);
}
