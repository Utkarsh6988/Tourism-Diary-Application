package com.jpa.exercise.dao;

import org.springframework.data.repository.CrudRepository;

import com.jpa.exercise.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
   
}

