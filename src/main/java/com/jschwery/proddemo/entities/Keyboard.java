package com.jschwery.proddemo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Keyboards")
public class Keyboard {

    @Column(name = "Keyboard_ID")
    @SequenceGenerator(name = "keyboardSequence", sequenceName = "keyboardSequence",
    allocationSize = 1)
    @GeneratedValue(generator = "keyboardSequence", strategy = GenerationType.SEQUENCE)
    @Id
    long keyboardID;


}
