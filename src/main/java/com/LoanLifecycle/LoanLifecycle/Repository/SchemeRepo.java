package com.LoanLifecycle.LoanLifecycle.Repository;

import com.LoanLifecycle.LoanLifecycle.Entity.SchemeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchemeRepo extends JpaRepository<SchemeEntity,Integer> {
    boolean existsBySchemeNameAndInterestRateAndLoanId(String schemeName, String interestRate, int loanId);
}
