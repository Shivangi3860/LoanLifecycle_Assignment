package com.LoanLifecycle.LoanLifecycle.Repository;

import com.LoanLifecycle.LoanLifecycle.Entity.accEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Acc_repo extends JpaRepository<accEntity, Integer> {

    boolean existsByAccountNo(String accountNo);
}
