package com.LoanLifecycle.LoanLifecycle.Repository;


import com.LoanLifecycle.LoanLifecycle.Entity.appraisalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppraisalRepo extends JpaRepository<appraisalEntity, Integer> {
    boolean existsByJewelNameAndJewelNetWt(String jewelName, String jewelNetWt);
}
