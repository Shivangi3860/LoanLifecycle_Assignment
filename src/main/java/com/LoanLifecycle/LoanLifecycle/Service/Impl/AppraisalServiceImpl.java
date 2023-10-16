package com.LoanLifecycle.LoanLifecycle.Service.Impl;

import com.LoanLifecycle.LoanLifecycle.Entity.appraisalEntity;
import com.LoanLifecycle.LoanLifecycle.Repository.AppraisalRepo;
import com.LoanLifecycle.LoanLifecycle.Service.AppraisalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppraisalServiceImpl implements AppraisalService {
    @Autowired
    private AppraisalRepo apprepo;


    @Override
    public List<appraisalEntity> getAllAppraisal() {
        return apprepo.findAll();
    }

    @Override
    public appraisalEntity getAppraisalById(int id) {
        Optional<appraisalEntity> appraisalData = apprepo.findById(id);
        if(appraisalData.isPresent()){
            return appraisalData.get();
        }
        else
            throw new RuntimeException("loan details not found with given ID");
    }

    @Override
    public void saveappraisalData(appraisalEntity appraisal) {
        appraisalEntity tempdata = new appraisalEntity();
        tempdata.setLoanId(appraisal.getLoanId());
        tempdata.setJewelName(appraisal.getJewelName());
        tempdata.setJewelNetWt(appraisal.getJewelNetWt());
        appraisalEntity appdetails = apprepo.save(tempdata);
        if(appdetails!=null){
            System.out.println("Details are saved");
        }
    }

    @Override
    public void UpdateAppraisal(appraisalEntity appraisal, int appraisalId) {
        Optional<appraisalEntity> appraisalOpt = apprepo.findById(appraisalId);
        if(appraisalOpt.isPresent()){

            appraisalEntity appraisalDetail = appraisalOpt.get();
            appraisalDetail.setLoanId(appraisal.getLoanId());
            appraisalDetail.setJewelNetWt(appraisal.getJewelNetWt());
            appraisalDetail.setJewelName(appraisal.getJewelName());
            apprepo.save(appraisalDetail);
        }
    }

    @Override
    public void DeleteAppraisal(int appraisalId) {
        Optional<appraisalEntity> appraisalOpt = apprepo.findById(appraisalId);
        if(appraisalOpt.isEmpty()){
            throw new RuntimeException("user not found.");
        }
        apprepo.deleteById(appraisalId);
    }


}
