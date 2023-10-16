package com.LoanLifecycle.LoanLifecycle.Service.Impl;

import com.LoanLifecycle.LoanLifecycle.Entity.TransactionEntity;
import com.LoanLifecycle.LoanLifecycle.Repository.TransactionRepo;
import com.LoanLifecycle.LoanLifecycle.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepo transactionRepo;

    @Override
    public List<TransactionEntity> getAllTransaction() {
        return transactionRepo.findAll();
    }

    @Override
    public TransactionEntity GetTransationById(int TransactionId) {
        Optional<TransactionEntity>Transaction = transactionRepo.findById(TransactionId);
        if(Transaction.isPresent()){
            return Transaction.get();
        }
        else{
            throw new RuntimeException("Transaction details not found with given ID");
        }
    }

    @Override

    public void SaveTransaction(TransactionEntity transaction) {

        int loanId = transaction.getLoanId();
        int accountId = transaction.getAccountId();

        Optional<TransactionEntity> existingTransaction = transactionRepo.findByLoanIdAndAccountId(loanId, accountId);
        if(existingTransaction.isPresent()) {
            throw new RuntimeException("A transaction already exists for the given loanId and accountId.");
        }
         transactionRepo.save(transaction);
    }

    @Override
    public void DeleteTransaction(int TransactionId) {
    Optional<TransactionEntity>Transaction = transactionRepo.findById(TransactionId);
    if(Transaction.isEmpty()){
        throw new RuntimeException("Transaction not found.");
    }
    else {
        transactionRepo.deleteById(TransactionId);
    }
    }
}
