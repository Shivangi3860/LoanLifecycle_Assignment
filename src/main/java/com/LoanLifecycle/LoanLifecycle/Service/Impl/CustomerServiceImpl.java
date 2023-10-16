package com.LoanLifecycle.LoanLifecycle.Service.Impl;

import com.LoanLifecycle.LoanLifecycle.Entity.CustomerEntity;
import com.LoanLifecycle.LoanLifecycle.Repository.CustomerRepo;
import com.LoanLifecycle.LoanLifecycle.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepository;
    @Override
    public List<CustomerEntity> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity getCustomerbyId(int CustomerId) {
        Optional<CustomerEntity> CustomerOpt = customerRepository.findById(CustomerId);
        if(CustomerOpt.isPresent())
            return CustomerOpt.get();
        else
            throw new RuntimeException("user not found.");
    }

    @Override
    public void saveCustomer(CustomerEntity Customer) {
        CustomerEntity example = new CustomerEntity();
        example.setName(Customer.getName());
        example.setPhone(Customer.getPhone());
        CustomerEntity CustomerDetail = customerRepository.save(example);
        System.out.println("Customer saved to db with CustomerId : " + CustomerDetail.getCustomerId());
    }


    @Override
    public void UpdateCustomer(CustomerEntity Customer, int CustomerId) {
        Optional<CustomerEntity> CustomerDetailOpt = customerRepository.findById(CustomerId);
        if(CustomerDetailOpt.isPresent()){
            CustomerEntity CustomerDetail = CustomerDetailOpt.get();
            if(Customer.getName() != null || Customer.getName().isEmpty())
                CustomerDetail.setName(Customer.getName());
            if(Customer.getPhone() != null || Customer.getPhone().isEmpty())
                CustomerDetail.setPhone(Customer.getPhone());
            customerRepository.save(CustomerDetail);
        }else{
            throw new RuntimeException("user not found.");
        }
    }

    @Override
    public void DeleteCustomer(int CustomerId) {
        Optional<CustomerEntity> CustomerOpt = customerRepository.findById(CustomerId);
        if(CustomerOpt.isEmpty())
            throw new RuntimeException("user not found.");
        else
            customerRepository.deleteById(CustomerId);

    }
}
