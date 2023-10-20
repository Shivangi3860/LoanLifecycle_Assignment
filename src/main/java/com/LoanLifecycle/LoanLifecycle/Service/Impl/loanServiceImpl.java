package com.LoanLifecycle.LoanLifecycle.Service.Impl;

import com.LoanLifecycle.LoanLifecycle.Entity.loanEntity;
import com.LoanLifecycle.LoanLifecycle.Repository.loanRepo;
import com.LoanLifecycle.LoanLifecycle.Service.LoanService;
import org.hibernate.sql.ast.tree.expression.Over;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class loanServiceImpl implements LoanService {
    @Autowired
    private loanRepo loanrepo;

    @Override
    public List<loanEntity> getAllLoan() {
        return loanrepo.findAll();
    }

    @Override
    public  loanEntity getLoanbyId(int loanId){
        Optional<loanEntity>loanOpt = loanrepo.findById(loanId);
        if(loanOpt.isPresent())
            return loanOpt.get();
        else
            throw new RuntimeException("loan details not found with given ID");
    }


    @Override
    public void saveLoanData(loanEntity loandata){
        loanEntity tempLoan = new loanEntity();
        tempLoan.setLenderId(loandata.getLenderId());
        tempLoan.setCustomerId(loandata.getCustomerId());
        tempLoan.setAssignationAmount(loandata.getAssignationAmount());
        tempLoan.setClosingAmount(loandata.getClosingAmount());
        tempLoan.setPrincipalAmount(loandata.getPrincipalAmount());
        tempLoan.setAppraisalId(loandata.getAppraisalId());
        tempLoan.setSchemeId(loandata.getSchemeId());

        loanEntity loandetails = loanrepo.save(tempLoan);

            System.out.println("loan details are saved");

    }

    @Override
    public String UpdateLoan(loanEntity loandata, int loanId){
        Optional<loanEntity>LoanOpt = loanrepo.findById(loanId);
        if(LoanOpt.isPresent()){
            loanEntity LoanSetData = LoanOpt.get();
            LoanSetData.setCustomerId(loandata.getCustomerId());
            LoanSetData.setPrincipalAmount(loandata.getPrincipalAmount());
            LoanSetData.setClosingAmount(loandata.getClosingAmount());
            LoanSetData.setAssignationAmount(loandata.getAssignationAmount());
            LoanSetData.setAppraisalId(loandata.getAppraisalId());
            LoanSetData.setSchemeId(loandata.getSchemeId());
            loanrepo.save(LoanSetData);
            return "Loan Service Updated";
        }

       else {
           return "No Loan is available with given LoanId";
        }
    }

    @Override
    public String DeleteLoan( int loanId){
        Optional<loanEntity> TobeDeleted = loanrepo.findById(loanId);
        if(TobeDeleted.isEmpty()){
            return "user not found.";
        }
        else {
            loanrepo.deleteById(loanId);
            return "User Has Been deleted";
        }
    }



}
