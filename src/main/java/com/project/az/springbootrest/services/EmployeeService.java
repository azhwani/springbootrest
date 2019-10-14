package com.project.az.springbootrest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.az.springbootrest.dao.EmployeeRepository;
import com.project.az.springbootrest.models.Employee;

@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	private EmployeeRepository emprepo;

	public EmployeeService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Optional<Employee> findByName(String name) {
		// TODO Auto-generated method stub
		return emprepo.findByName(name);
	}

}
