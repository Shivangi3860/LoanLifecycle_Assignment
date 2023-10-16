package com.LoanLifecycle.LoanLifecycle.Service;

import com.LoanLifecycle.LoanLifecycle.Entity.appraisalEntity;

import java.util.List;

public interface AppraisalService {
    List<appraisalEntity>getAllAppraisal();
    appraisalEntity getAppraisalById(int id);
    void saveappraisalData(appraisalEntity appraisal);

    void UpdateAppraisal(appraisalEntity appraisal,int appraisalId);

    void DeleteAppraisal(int appraisalId);
}
