package com.LoanLifecycle.LoanLifecycle.Service;

import com.LoanLifecycle.LoanLifecycle.Entity.TransactionEntity;

import java.util.List;

public interface TransactionService {

    List<TransactionEntity> getAllTransaction();
    TransactionEntity GetTransationById(int TransactionId);

    void SaveTransaction(TransactionEntity Transaction);

    void DeleteTransaction(int TransactionId);


}
