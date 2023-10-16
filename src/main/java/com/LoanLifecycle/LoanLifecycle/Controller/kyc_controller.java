package com.LoanLifecycle.LoanLifecycle.Controller;

import com.LoanLifecycle.LoanLifecycle.Service.Impl.Kyc_Service;
import com.LoanLifecycle.LoanLifecycle.dto.KYCDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@SpringBootApplication
@RestController
@RequestMapping("/kyc_docs")
public class kyc_controller {
    @Autowired
    private Kyc_Service service;

    @PostMapping("/UploadKycDocs")
    public ResponseEntity<?> uploadKycDocs(
                                        @RequestParam("adhar_back") MultipartFile adharBack,
                                        @RequestParam("adhar_front") MultipartFile adharFront,
                                        @RequestParam("pan") MultipartFile pan,
                                        @RequestParam("customer_id") int customer_id) throws IOException {
     String UploadKyc = service.UploadKyc(adharFront,adharBack,pan,customer_id);

        return ResponseEntity.status(HttpStatus.OK).body(UploadKyc);
    }

    @GetMapping("/adhar_front/{customerId}")
    public ResponseEntity<?> DownloadAdharFront(@PathVariable int customerId) throws IOException {
           KYCDtoResponse response =  service.GetadharFront(customerId);
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }


}

