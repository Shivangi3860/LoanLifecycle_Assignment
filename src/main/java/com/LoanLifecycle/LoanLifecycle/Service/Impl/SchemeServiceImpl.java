package com.LoanLifecycle.LoanLifecycle.Service.Impl;

import com.LoanLifecycle.LoanLifecycle.Entity.SchemeEntity;
import com.LoanLifecycle.LoanLifecycle.Repository.SchemeRepo;
import com.LoanLifecycle.LoanLifecycle.Service.SchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SchemeServiceImpl implements SchemeService {

    @Autowired
    private SchemeRepo schemeRepo;
    @Override
    public List<SchemeEntity> getAllSchemes() {
        return schemeRepo.findAll();
    }

    @Override
    public SchemeEntity getSchemeId(int id) {
        Optional<SchemeEntity> schemeData = schemeRepo.findById(id);
        if(schemeData.isPresent()){
            return schemeData.get();
        }
        else {
            throw new RuntimeException("loan details not found with given ID");
        }
    }

    @Override
    public String SaveScheme(SchemeEntity schemeData) {
        boolean schemeExists = schemeRepo.existsBySchemeNameAndInterestRate(
                schemeData.getSchemeName(),
                schemeData.getInterestRate()
        );

        if (!schemeExists) {
            if (!schemeData.getInterestRate().matches("\\d+")) {
                throw new IllegalArgumentException("JewelName should only contain numeric characters");
            }
            SchemeEntity tempData = new SchemeEntity();
            tempData.setSchemeName(schemeData.getSchemeName());
            tempData.setInterestRate(schemeData.getInterestRate());

            schemeRepo.save(tempData);
            return "Scheme details are saved";
        } else {
            return "Scheme with the given loan id and interestRate already exists";
        }
    }

    @Override
    public String updateScheme(int schemeId,SchemeEntity schemeData){

        Optional<SchemeEntity>SchemeOpt = schemeRepo.findById(schemeId);
        boolean schemeExists = schemeRepo.existsBySchemeNameAndInterestRate(
                schemeData.getSchemeName(),
                schemeData.getInterestRate()
        );
        if(SchemeOpt.isPresent() && !schemeExists ){

            if (!schemeData.getInterestRate().matches("\\d+")) {
                throw new IllegalArgumentException("InterestRate should only contain numeric characters");
            }

            SchemeEntity SchemeDataSet = SchemeOpt.get();
            SchemeDataSet.setSchemeName(schemeData.getSchemeName());
            SchemeDataSet.setInterestRate(schemeData.getInterestRate());
            schemeRepo.save(SchemeDataSet);
            return "Scheme Updated SuccessFully";
        }
        else {
            return "Scheme with the given loan id and interestRate already exists or scheme with given id is not found";
        }


    }

    @Override
    public void DeleteScheme(int SchemeId){
        Optional<SchemeEntity> TobeDeleted = schemeRepo.findById(SchemeId);
        if(TobeDeleted.isEmpty()){
            throw new RuntimeException("Scheme not found.");
        }
        else {
            schemeRepo.deleteById(SchemeId);
        }
    }
}
