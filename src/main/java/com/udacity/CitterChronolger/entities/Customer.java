package com.udacity.CitterChronolger.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    private String name;
    @Getter
    private String phoneNumber;
    @Getter
    private String notes;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Pet> pets = new ArrayList<>();

    public List<Pet> getPets() {
        if (pets == null) {
            pets = new ArrayList<>();
        }
        return pets;
    }
    public void insertPet(Pet pet) {
        if (this.pets == null) {
            this.pets = new ArrayList<>();
        }
        this.pets.add(pet);
    }
}
