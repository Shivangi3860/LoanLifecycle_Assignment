package com.LoanLifecycle.LoanLifecycle.Controller;

import com.LoanLifecycle.LoanLifecycle.Entity.CustomerEntity;
import com.LoanLifecycle.LoanLifecycle.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

    @Autowired
    private CustomerService CustomerService;
    @GetMapping
    public List<CustomerEntity> getAllCustomer(){
        List<CustomerEntity> Customers = CustomerService.getAllCustomer();
            System.out.println("Customers :" +Customers );
        return Customers;

    }

    @GetMapping("/{CustomerId}")
    public CustomerEntity getCustomerbyId(@PathVariable int CustomerId){
        CustomerEntity Customer = CustomerService.getCustomerbyId(CustomerId);
        System.out.println("CustomerId : "+ CustomerId+" Customer : "+Customer);
        return Customer;
    }

    @PostMapping
    public String saveCustomer(@RequestBody CustomerEntity Customer){
        CustomerService.saveCustomer(Customer);
        return "Customer saved SuccessFully";
    }

    @PutMapping("{CustomerId}")
    public String UpdateCustomer(@RequestBody CustomerEntity Customer, @PathVariable int CustomerId){
        CustomerService.UpdateCustomer(Customer,CustomerId);
        return "Customer Updated SuccessFully";
    }

    @DeleteMapping("/{CustomerId}")
    public String DeleteCustomer(@PathVariable int CustomerId){
        CustomerService.DeleteCustomer(CustomerId);
        return "Customer Deleted SuccessFully";
    }



}


