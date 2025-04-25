package com.udacity.CitterChronolger.repositories;

import com.udacity.CitterChronolger.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetsRepository extends JpaRepository<Pet, Long> {
    List<Pet> getAllByCustomerId(Long customerId);
}
