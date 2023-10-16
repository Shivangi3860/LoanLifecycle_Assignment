package com.LoanLifecycle.LoanLifecycle.Controller;

import com.LoanLifecycle.LoanLifecycle.Entity.appraisalEntity;
import com.LoanLifecycle.LoanLifecycle.Service.AppraisalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Appraisal")
public class AppraisalController {
    @Autowired
    private AppraisalService appraisalService;

    @GetMapping
    public List<appraisalEntity>getAllAppraisal(){
        List<appraisalEntity> appraisalData = appraisalService.getAllAppraisal();
        return appraisalData;
    }

    @GetMapping("{appraisalId}")
    public appraisalEntity appRaisalData(@PathVariable int appraisalId){
        appraisalEntity appraisalData = appraisalService.getAppraisalById(appraisalId);
        return appraisalData;
    }

    @PostMapping
    public String UploadAppraisal(@RequestBody appraisalEntity appdata){
        appraisalService.saveappraisalData(appdata);
        return "Appraisal Data is Saved";
    }

    @PutMapping("{appraisalId}")
    public String UpdateAppraisal(@RequestBody appraisalEntity appraisal, @PathVariable int appraisalId){
        appraisalService.UpdateAppraisal(appraisal,appraisalId);
        return "Appraisal Updated SuccessFully";
    }

    @DeleteMapping("{appraisalId}")
    public String DeleteAppraisal(@PathVariable int appraisalId){
        appraisalService.DeleteAppraisal(appraisalId);
        return "Appraisal Deleted SuccessFully";
    }

}
