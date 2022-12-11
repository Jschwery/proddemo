package com.jschwery.proddemo.services.implementation;

import com.jschwery.proddemo.entities.Customer;
import com.jschwery.proddemo.repositories.CustomerRepository;
import com.jschwery.proddemo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository repository;
    @Autowired
    CustomerServiceImpl(CustomerRepository customerRepository){
        this.repository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customerToSave) {
        return repository.save(customerToSave);
    }
}
