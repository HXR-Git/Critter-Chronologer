package com.udacity.CitterChronolger.entities;

import com.udacity.CitterChronolger.user.EmployeeSkill;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "schedule")
@Data
@NoArgsConstructor
public class Schedule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    @JoinTable(
            name = "schedule_employee",
            joinColumns = @JoinColumn(name = "schedule_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Employee> employees;

    @ManyToMany
    @JoinTable(
            name = "schedule_pet",
            joinColumns = @JoinColumn(name = "schedule_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id")
    )
    private List<Pet> pets;

    private LocalDate date;

    @ElementCollection
    @CollectionTable(name = "schedule_activities", joinColumns = @JoinColumn(name = "schedule_id"))
    @Column(name = "activity")
    private Set<EmployeeSkill> activities;

    // Explicit getters/setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public List<Employee> getEmployees() { return employees; }
    public void setEmployees(List<Employee> employees) { this.employees = employees; }

    public List<Pet> getPets() { return pets; }
    public void setPets(List<Pet> pets) { this.pets = pets; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Set<EmployeeSkill> getActivities() { return activities; }
    public void setActivities(Set<EmployeeSkill> activities) { this.activities = activities; }

}
