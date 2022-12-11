package com.jschwery.proddemo.services;

import com.jschwery.proddemo.entities.Customer;
import org.springframework.stereotype.Service;


@Service
public interface CustomerService {
    public Customer saveCustomer(Customer customerToSave) ;

}
