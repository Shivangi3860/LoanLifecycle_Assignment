package com.LoanLifecycle.LoanLifecycle.Repository;

import com.LoanLifecycle.LoanLifecycle.Entity.KycEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface kycRepo  extends JpaRepository<KycEntity,Integer> {

    KycEntity findByCustomerId(int customer_id);

}
