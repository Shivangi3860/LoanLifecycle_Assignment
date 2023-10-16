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

        String jewelName = appraisal.getJewelName();
        String jewelNetWt = appraisal.getJewelNetWt();
        int loanId = appraisal.getLoanId();

        if (jewelName == null || jewelName.isEmpty()) {
            throw new IllegalArgumentException("JewelName cannot be null or empty");
        }

        if (jewelNetWt == null || jewelNetWt.isEmpty()) {
            throw new IllegalArgumentException("JewelNetWt cannot be null or empty");
        }

        if (!jewelName.matches("\\d+")) {
            throw new IllegalArgumentException("JewelName should only contain numeric characters");
        }
        boolean appraisalExists = apprepo.existsByLoanIdAndJewelNameAndJewelNetWt(loanId, jewelName, jewelNetWt);
        if (appraisalExists) {
            throw new IllegalArgumentException("Appraisal with the same loanId, jewelName, and jewelNetWt already exists");
        }

        appraisalEntity tempdata = new appraisalEntity();
        tempdata.setLoanId(appraisal.getLoanId());
        tempdata.setJewelName(jewelName);
        tempdata.setJewelNetWt(jewelNetWt);

        appraisalEntity appdetails = apprepo.save(tempdata);
        System.out.println("Details are saved");
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
