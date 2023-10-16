package com.LoanLifecycle.LoanLifecycle.Repository;

import com.LoanLifecycle.LoanLifecycle.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer>{

}
