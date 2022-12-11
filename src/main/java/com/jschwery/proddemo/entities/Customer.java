package com.jschwery.proddemo.entities;

import com.jschwery.proddemo.exceptions.CustomerException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "Customers")
public class Customer {

    @Id
    @SequenceGenerator(name = "CustomerSequence",
    sequenceName = "CustomerSequence",
    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "CustomerSequence")


    @Column(name = "Customer_ID", unique = true, nullable = false)
    long customerID;

    @Column(name = "Customer_Name")
    String customerName;
    @Column(name = "Customer_Email",
            unique = true,
            nullable = false)
    String customerEmail;
    @Column(name = "Created_Account")
    Timestamp timeAccountCreated;

}
