package com.LoanLifecycle.LoanLifecycle.Entity;


import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.ZonedDateTime;

@Entity
@Table(name = "Fund_Transfer    ", schema="public")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer Id;

    @Column(name = "loan_id")
    private int loanId;

    @Column(name = "account_id")
    private int accountId;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public int getLoanId() {
        return loanId;
    }



    public int getAccountId() {
        return accountId;
    }











}
