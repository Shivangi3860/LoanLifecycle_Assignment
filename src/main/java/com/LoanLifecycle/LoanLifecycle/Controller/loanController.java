package com.LoanLifecycle.LoanLifecycle.Controller;


import com.LoanLifecycle.LoanLifecycle.Entity.loanEntity;
import com.LoanLifecycle.LoanLifecycle.Service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Loan")
public class loanController {

  @Autowired
    private LoanService loanService;

    @GetMapping
    public List<loanEntity> GetAllLoan(){
      return loanService.getAllLoan();
    }

    @GetMapping("/{LoanId}")
    public loanEntity getLoanById(@PathVariable int LoanId){
      return loanService.getLoanbyId(LoanId);

    }

  @PostMapping
  public String uploadLoanDetails(@RequestBody loanEntity loandata){
    loanService.saveLoanData(loandata);
      return "loan details are saved";
    }

    @PutMapping("/{LoanId}")
  public String UpdateLoanById(@RequestBody loanEntity Loandata, @PathVariable int LoanId){
      return loanService.UpdateLoan(Loandata,LoanId);
 }

 @DeleteMapping("/{LoanId}")
 public String DeleteLoanId( @PathVariable int LoanId){
   return loanService.DeleteLoan(LoanId);
 }




}




