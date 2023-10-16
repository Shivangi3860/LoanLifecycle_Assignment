package com.LoanLifecycle.LoanLifecycle.Repository;

import com.LoanLifecycle.LoanLifecycle.Entity.loanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface loanRepo extends JpaRepository<loanEntity,Integer> {
}
