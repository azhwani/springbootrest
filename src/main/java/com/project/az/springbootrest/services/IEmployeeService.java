package com.project.az.springbootrest.services;

import java.util.List;
import java.util.Optional;

import com.project.az.springbootrest.models.Employee;

public interface IEmployeeService {
	
	List<Employee> getAllEmployees();
	Optional<Employee> findById(int id);
	Optional<Employee> findByName(String name);
	Optional<Employee> getEmployeeByEmail(String email);
	
	Employee save(Employee emp);
	Employee update(Long id, Employee emp);
	void delete(int id);
	
	

}
