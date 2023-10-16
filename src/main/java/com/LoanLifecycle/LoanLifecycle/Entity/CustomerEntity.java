package com.LoanLifecycle.LoanLifecycle.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "customer", schema="public")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Integer CustomerId;

    @Column
    private String Name;
    @Column
    private String Phone;

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(Integer customerId) {
        CustomerId = customerId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
