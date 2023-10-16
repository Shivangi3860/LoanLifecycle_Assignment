package com.LoanLifecycle.LoanLifecycle.Service;



import com.LoanLifecycle.LoanLifecycle.Entity.loanEntity;

import java.util.List;

public interface LoanService {
    List<loanEntity> getAllLoan();
     loanEntity getLoanbyId(int loanId);

     void saveLoanData(loanEntity loandata);

     String UpdateLoan(loanEntity LoanData, int loanId);

     String DeleteLoan(int loanId);

}
