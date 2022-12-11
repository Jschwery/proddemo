package com.jschwery.proddemo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Manufacturer")
public class Manufacturer {
    @Id
    @SequenceGenerator(name = "manufacturerSequence",
                       sequenceName = "manufacturerSequence",
                       allocationSize = 1)
    @GeneratedValue(generator = "manufacturerSequence",
    strategy = GenerationType.SEQUENCE)
    @Column(name = "Manufacturer_ID", unique = true, nullable = false)
    long manufacturerId;


}
