package com.eea.timetablesystem.Web;


import com.eea.timetablesystem.Model.Batches;
import com.eea.timetablesystem.Service.BatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BatchesController
{
    @Autowired
    private BatchesService batchesService;

    @GetMapping("/batches")
    public String batches(Model model)
    {
        model.addAttribute("listBatches",batchesService.getAllBatches());
        return "batches";
    }

    @GetMapping("/addBatch")
    public String addBatch(Model model)
    {
        Batches batches=new Batches();
        model.addAttribute("batches",batches);
        return "addBatch";
    }

    @PostMapping("/addBatch")
    public String addBatch(@ModelAttribute("batches")Batches batches)
    {
        batchesService.addBatch(batches);
        return "redirect:/batches";
    }

    @GetMapping("/showFormForUpdateBatches/{id}")
    public String showFormForUpdateBatches(@PathVariable(value = "id")int id,Model model)
    {
        Batches batches=batchesService.getBatchById(id);

        model.addAttribute("batches",batches);
        return "updateBatch";
    }

    @GetMapping("/deleteBatch/{id}")
    public String deleteBatch(@PathVariable(value = "id")int id){
        this.batchesService.deleteBatchesById(id);
        return "redirect:/batches";

    }




}
