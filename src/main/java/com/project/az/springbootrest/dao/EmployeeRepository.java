package com.project.az.springbootrest.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.az.springbootrest.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	Optional<Employee> findByName(String name);
	
	Optional<Employee> getEmployeeByEmail(String email);

}
