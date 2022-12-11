package com.jschwery.proddemo.services.implementation;

import com.jschwery.proddemo.entities.Customer;
import com.jschwery.proddemo.repositories.CustomerRepository;
import com.jschwery.proddemo.repositories.ManufacturerRepository;
import com.jschwery.proddemo.services.CustomerService;
import com.jschwery.proddemo.services.ManufacturerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
class CustomerServiceImplTest {

    @Mock
    CustomerRepository customerRepository;
    CustomerServiceImpl customerServiceimpl;
    ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
    Customer customer = Customer.builder().
            customerEmail("testemail@gmail.com")
            .customerName("john")
            .timeAccountCreated(Timestamp.valueOf(zdt.toLocalDateTime()))
            .build();

    @BeforeEach
    void setUp() {
        customerServiceimpl = new CustomerServiceImpl(customerRepository);
        Customer customerOutput = Customer.builder().
                customerEmail("testemail.gmail.com")
                .customerName("john")
                .timeAccountCreated(Timestamp.valueOf(zdt.toLocalDateTime()))
                .customerID(1)
                .build();
        Mockito.when(customerRepository.save(customer)).thenReturn(customerOutput);
    }
    @Test
    void saveCustomer() {
        assertEquals(1, customerServiceimpl.saveCustomer(customer).getCustomerID());
    }
}