package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.*;
import com.auGrad.Backend.services.SelectedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SelectedController {

    @Autowired
    private SelectedService selectedService;

    @PostMapping("/addSelectedGrad")
    private ResponseEntity<Selected> saveSelectedGrad(@RequestBody Selected selectedGrad){
        try {
            return ResponseEntity.ok().body(this.selectedService.addSelectedGrad(selectedGrad));
        }
        catch (Exception e){
            throw new NoObjectFoundException("Error");
        }
    }

    @PostMapping("/deleteSelectedGrad")
    private ResponseEntity<Integer> deleteSelectedGrad(@RequestBody Selected selectedGrad){
        try {
            return ResponseEntity.ok().body(this.selectedService.deleteSelectedGrad(selectedGrad));
        }
        catch (Exception e){
            throw new NoObjectFoundException("error" + e);
        }
    }

    @GetMapping("/allSelectedGrads")
    private ResponseEntity<List<Selected>> getAllSelectedGrads(){
        return ResponseEntity.ok().body(this.selectedService.getSelectedGrads());
    }

    @GetMapping("/isGradSelected/{empId}/{jobId}")
    private ResponseEntity<Boolean> getRequirementsByBatchId(@PathVariable int empId, @PathVariable int jobId)
    {
        return ResponseEntity.ok().body(this.selectedService.isGradSelected(empId,jobId));
    }
    @GetMapping("/selectedCountByBatchId/{batchId}")
    private ResponseEntity<Integer> getEmployeeCountByBatchId(@PathVariable int batchId)
    {
        return ResponseEntity.ok().body(this.selectedService.getEmployeesCountByBatchId(batchId));
    }


}
