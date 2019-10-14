package com.project.az.springbootrest.services;

import java.util.Optional;

import com.project.az.springbootrest.models.Employee;

public interface IEmployeeService {
	
	Optional<Employee> findByName(String name);

}
