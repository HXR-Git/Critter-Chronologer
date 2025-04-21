package com.udacity.CitterChronolger.entities;

import com.udacity.CitterChronolger.pet.PetType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "pet")
@Data
@NoArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate birthDate;
    private String notes;

    @Enumerated(EnumType.STRING)
    private PetType type;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
