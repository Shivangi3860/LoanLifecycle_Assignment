package com.LoanLifecycle.LoanLifecycle.Entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Table(name = "scheme")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SchemeEntity {

@Id
@Column
@GeneratedValue(strategy = GenerationType.AUTO)
private int Id;

@Column(name="scheme_name")
private String schemeName;

 @Column(name="interest_rate")
  private String interestRate;

 @Column(name="loan_id")
 private int loanId;

    public void setId(int id) {
        Id = id;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }


}
