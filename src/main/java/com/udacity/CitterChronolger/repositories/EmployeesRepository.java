package com.udacity.CitterChronolger.repositories;

import com.udacity.CitterChronolger.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.DayOfWeek;
import java.util.List;

public interface EmployeesRepository extends JpaRepository<Employee, Long> {
    List<Employee> getAllByDaysAvailableContains(DayOfWeek dayOfWeek);
}
