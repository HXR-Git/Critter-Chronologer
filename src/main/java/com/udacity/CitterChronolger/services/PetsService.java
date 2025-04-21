package com.udacity.CitterChronolger.services;

import com.udacity.CitterChronolger.entities.Customer;
import com.udacity.CitterChronolger.entities.Pet;
import com.udacity.CitterChronolger.repositories.CustomersRepository;
import com.udacity.CitterChronolger.repositories.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PetsService {

    @Autowired
    private PetsRepository petsRepository;

    @Autowired
    private CustomersRepository customersRepository;

    public List<Pet> getAllPets() {
        return petsRepository.findAll();
    }

    public List<Pet> getPetsByCustomerId(long customerId) {
        return petsRepository.getAllByCustomerId(customerId);
    }

    public Pet getPetById(long petId) {
        return petsRepository.getOne(petId);
    }

    public Pet savePet(Pet pet, long ownerId) {
        Customer customer = customersRepository.getOne(ownerId);
        pet.setCustomer(customer);
        pet = petsRepository.save(pet);
        customer.getPets().add(pet);
        customersRepository.save(customer);
        return pet;
    }
}
