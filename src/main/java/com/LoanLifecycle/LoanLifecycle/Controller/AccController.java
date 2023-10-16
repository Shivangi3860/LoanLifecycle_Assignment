package com.LoanLifecycle.LoanLifecycle.Controller;
import com.LoanLifecycle.LoanLifecycle.Entity.accEntity;
import com.LoanLifecycle.LoanLifecycle.Service.Acc_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acc_details")


public class AccController {
    @Autowired
    private Acc_Service acc_service;

    @GetMapping
    public List<accEntity> getAll(){
        List<accEntity> AllAcc = acc_service.getAll();
        System.out.println("All Account Details:"+ AllAcc);
        return AllAcc;
    }


    @PostMapping
    public String saveAcc(@RequestBody accEntity acc_details){
        acc_service.saveAcc(acc_details);
        return "Acc Details are saved";
    }


    @GetMapping("{acc_id}")
    public accEntity getAccById(@PathVariable int acc_id){
        accEntity acc_details = acc_service.getAccById(acc_id);
        return acc_details;

    }

    @PutMapping("{acc_id}")
    public String updateAcc(@RequestBody accEntity acc_details, @PathVariable int acc_id){
        acc_service.updateAcc(acc_details,acc_id);
        return "Details Updated SuccessFully";
    }

     @DeleteMapping("{acc_id}")
        public String DeleteAcc(@PathVariable int acc_id){
            acc_service.DeleteAcc(acc_id);
            return "Account Details Deleted SuccessFully";
        }


}
