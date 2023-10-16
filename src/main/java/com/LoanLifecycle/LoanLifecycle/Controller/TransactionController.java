package com.LoanLifecycle.LoanLifecycle.Controller;

import com.LoanLifecycle.LoanLifecycle.Entity.TransactionEntity;
import com.LoanLifecycle.LoanLifecycle.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<TransactionEntity>getAllTransation(){
        return transactionService.getAllTransaction();
    }
    @GetMapping("{TransactionId}")
    public TransactionEntity getTransactionById(@PathVariable int TransactionId){
        return transactionService.GetTransationById(TransactionId);
    }

    @PostMapping
    public String SaveTransaction(@RequestBody TransactionEntity Transaction){
        transactionService.SaveTransaction(Transaction);
        return "Transaction saved SuccessFully";
    }

    @DeleteMapping("{TransactionId}")
    public String UpdateTransaction(@PathVariable int TransactionId){
        transactionService.DeleteTransaction(TransactionId);
        return "Transaction Deleted SuccessFully";
    }

}
