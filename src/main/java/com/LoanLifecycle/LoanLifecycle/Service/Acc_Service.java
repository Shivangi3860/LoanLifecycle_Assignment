package com.LoanLifecycle.LoanLifecycle.Service;

import com.LoanLifecycle.LoanLifecycle.Entity.accEntity;


import java.util.List;

public interface Acc_Service {

    List<accEntity> getAll();
    accEntity getAccById(int customer_id);

    void saveAcc(accEntity acc_details);

    void updateAcc(accEntity acc_details, int acc_id);

    void DeleteAcc(int customer_id) ;
}
