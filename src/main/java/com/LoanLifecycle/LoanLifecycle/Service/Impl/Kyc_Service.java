package com.LoanLifecycle.LoanLifecycle.Service.Impl;


import com.LoanLifecycle.LoanLifecycle.Entity.KycEntity;
import com.LoanLifecycle.LoanLifecycle.Repository.kycRepo;
import com.LoanLifecycle.LoanLifecycle.dto.KYCDtoResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;


@Service
public class Kyc_Service {

    private  final String FolderPath = "/Users/shivangi.mishra/Documents/FilePath/";
    @Autowired
    private kycRepo kyc_Repo;

    public String UploadKyc(MultipartFile adhar_front, @NotNull MultipartFile adhar_back, MultipartFile pan,
                            Integer customer_id) throws IOException {
     String FrontFilePath = FolderPath+ adhar_front.getOriginalFilename();
     String BackFilePath = FolderPath + adhar_back.getOriginalFilename();
     String PanPath = FolderPath+ pan.getOriginalFilename();

       KycEntity kyc_data = kyc_Repo.save(KycEntity.builder().customerId(customer_id).adhar_back(BackFilePath).pan(PanPath).adhar_front(FrontFilePath).build());

        adhar_front.transferTo(new File(FrontFilePath));
        adhar_back.transferTo(new File(BackFilePath));
        pan.transferTo(new File(PanPath));

       if(kyc_data!=null){
           return "files uploaded successfully to"+ FolderPath;
       }
       return null;
    }

    public KYCDtoResponse GetadharFront(int customerId) throws IOException {
        KycEntity kycEntity = kyc_Repo.findByCustomerId(customerId);

        KYCDtoResponse kycDtoResponse = new KYCDtoResponse();
        kycDtoResponse.setFront(kycEntity.getAdhar_front());

        kycDtoResponse.setBack(kycEntity.getAdhar_back());
        kycDtoResponse.setPan(kycEntity.getPan());

        return kycDtoResponse;

    }



}
