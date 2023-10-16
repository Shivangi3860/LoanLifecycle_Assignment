package com.LoanLifecycle.LoanLifecycle.Service;

import com.LoanLifecycle.LoanLifecycle.Entity.CustomerEntity;

import java.util.List;

public interface CustomerService {
    List<CustomerEntity>getAllCustomer();

    CustomerEntity getCustomerbyId(int CustomerId);

    void saveCustomer(CustomerEntity Customer);

    void UpdateCustomer(CustomerEntity Customer, int CustomerId);

    void DeleteCustomer(int CustomerId);


}
