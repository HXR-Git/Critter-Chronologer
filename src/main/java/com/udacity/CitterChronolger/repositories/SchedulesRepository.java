package com.udacity.CitterChronolger.repositories;

import com.udacity.CitterChronolger.entities.Employee;
import com.udacity.CitterChronolger.entities.Pet;
import com.udacity.CitterChronolger.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchedulesRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> getAllByPetsContains(Pet pet);

    List<Schedule> getAllByEmployeesContains(Employee employee);

    List<Schedule> getAllByPetsIn(List<Pet> pets);
}
