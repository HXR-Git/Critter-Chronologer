package com.udacity.CitterChronolger.repositories;

import com.udacity.CitterChronolger.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customer, Long> {

}
