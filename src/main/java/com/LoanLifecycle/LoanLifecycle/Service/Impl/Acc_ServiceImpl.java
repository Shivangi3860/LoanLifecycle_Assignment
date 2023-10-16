package com.LoanLifecycle.LoanLifecycle.Service.Impl;

import com.LoanLifecycle.LoanLifecycle.Entity.CustomerEntity;
import com.LoanLifecycle.LoanLifecycle.Entity.accEntity;
import com.LoanLifecycle.LoanLifecycle.Repository.Acc_repo;
import com.LoanLifecycle.LoanLifecycle.Service.Acc_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Acc_ServiceImpl implements Acc_Service {

    @Autowired
    private Acc_repo acc_repo;

    @Override
    public List<accEntity> getAll() {
        return acc_repo.findAll();

    }

    @Override
    public accEntity getAccById(int acc_id) {
        Optional<accEntity> Acc_Opt = acc_repo.findById(acc_id);
        if(Acc_Opt.isPresent())
            return Acc_Opt.get();
        else
            throw new RuntimeException("User Not Found");
    }


    @Override
    public void saveAcc(accEntity acc_details) {

        if (acc_details.getAccountNo() == null || acc_details.getAccountNo().isEmpty()) {
            throw new IllegalArgumentException("Account number is required");
        }
        boolean accountExists = acc_repo.existsByAccountNo(acc_details.getAccountNo());
        if (accountExists) {
            throw new IllegalArgumentException("Account number " + acc_details.getAccountNo() + " already exists");
        }

        Optional<accEntity> acc_detailsOpt = acc_repo.findById(acc_details.getCustomerId());
        if(acc_detailsOpt.isPresent()){
            throw new IllegalArgumentException("Account details already exist for customer with ID: " + acc_details.getCustomerId());
        }
        acc_repo.save(acc_details);
        System.out.println("Acc Details are saved");
    }


    @Override
    public void updateAcc(accEntity acc_details, int acc_id) {
        accEntity existingAcc = acc_repo.findById(acc_id).orElse(null);

        if (existingAcc != null) {
            existingAcc.setIfscCode(acc_details.getIfscCode());
            existingAcc.setAccountNo(acc_details.getAccountNo());
            existingAcc.setHolderName(acc_details.getHolderName());
            acc_repo.save(existingAcc);
        }
        else
            throw new RuntimeException("user not found");
  }


    @Override
    public void DeleteAcc(int acc_id) {
        Optional<accEntity> acc_details = acc_repo.findById(acc_id);
        if(acc_details.isEmpty())
            throw new RuntimeException("user not found.");
        else acc_repo.deleteById(acc_id);
    }
}
