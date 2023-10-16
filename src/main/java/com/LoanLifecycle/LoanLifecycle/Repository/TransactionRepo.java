package com.LoanLifecycle.LoanLifecycle.Repository;

import com.LoanLifecycle.LoanLifecycle.Entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepo extends JpaRepository<TransactionEntity,Integer> {
    Optional<TransactionEntity> findByLoanIdAndAccountId(int loanId, int accountId);

}
