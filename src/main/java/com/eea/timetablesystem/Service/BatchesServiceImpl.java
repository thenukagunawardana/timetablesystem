package com.eea.timetablesystem.Service;

import com.eea.timetablesystem.Model.Batches;
import com.eea.timetablesystem.Repository.BatchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatchesServiceImpl implements BatchesService
{
    @Autowired
    private BatchesRepository batchesRepository;


    @Override
    public List<Batches> getAllBatches()
    {
        return batchesRepository.findAll();
    }

    @Override
    public void addBatch(Batches batches)
    {
        this.batchesRepository.save(batches);
    }

    @Override
    public Batches getBatchById(int id)
    {
        Optional<Batches> optional=batchesRepository.findById(id);
        Batches batches=null;
        if (optional.isPresent())
        {
            batches=optional.get();

        }
        else
        {
            throw new RuntimeException("Batch not Found for matching ID"+id);

        }

        return batches;
    }

    @Override
    public void deleteBatchesById(int id)
    {
        this.batchesRepository.deleteById(id);

    }
}
