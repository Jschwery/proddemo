package com.jschwery.proddemo.controllers;

import com.jschwery.proddemo.entities.Customer;
import com.jschwery.proddemo.exceptions.CustomerException;
import com.jschwery.proddemo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @PostMapping("/customers")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) throws CustomerException {
        if(customer == null){
            throw new CustomerException("Customer could not be saved");
        }
        ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
        Customer customerToSave = Customer.builder().customerEmail(customer.getCustomerEmail()).
                customerName(customer.getCustomerName())
                .timeAccountCreated(Timestamp.valueOf(zdt.toLocalDateTime())).build();
        Customer returnedCustomer = customerService.saveCustomer(customerToSave);
        return new ResponseEntity<>(returnedCustomer, HttpStatus.ACCEPTED);
    }
}
