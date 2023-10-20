package com.LoanLifecycle.LoanLifecycle.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "loan")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class loanEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "customer_id")
        private int CustomerId;

    @Column(name = "lender_id")
        private int lenderId;



    @Column(name = "closing_amount")
    private String closingAmount;


    @Column(name = "appraisal_id")
    private int appraisalId;

    @Column(name = "scheme_id")
    private int schemeId;

    @Column(name = "principal_amount")
    private String principalAmount;

    @Column(name = "assignation_amount")
    private String assignationAmount;



    public int getAppraisalId() {
        return appraisalId;
    }

    public void setAppraisalId(int appraisalId) {
        this.appraisalId = appraisalId;
    }

    public int getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(int schemeId) {
        this.schemeId = schemeId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        this.CustomerId = customerId;
    }

    public int getLenderId() {
        return lenderId;
    }

    public void setLenderId(int lenderId) {
        this.lenderId = lenderId;
    }

    public String getClosingAmount() {
        return closingAmount;
    }

    public void setClosingAmount(String closingAmount) {
        this.closingAmount = closingAmount;
    }

    public String getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(String principalAmount) {
        this.principalAmount = principalAmount;
    }

    public String getAssignationAmount() {
        return assignationAmount;
    }

    public void setAssignationAmount(String assignationAmount) {
        this.assignationAmount = assignationAmount;
    }


}
