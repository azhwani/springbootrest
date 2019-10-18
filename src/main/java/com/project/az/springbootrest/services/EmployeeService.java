package com.project.az.springbootrest.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.az.springbootrest.dao.EmployeeRepository;
import com.project.az.springbootrest.models.Employee;

@Service
@Transactional
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	private EmployeeRepository emprepo;

	public EmployeeService() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return emprepo.findAll();
	}

	@Override
	public Optional<Employee> findById(int id) {
		// TODO Auto-generated method stub
		return emprepo.findById(id);
	}

	@Override
	public Optional<Employee> findByName(String name) {
		// TODO Auto-generated method stub
		return emprepo.findByName(name);
	}
	
	@Override
	public Optional<Employee> getEmployeeByEmail(String email) {
		// TODO Auto-generated method stub
		return emprepo.getEmployeeByEmail(email);
	}

	@Override
	public Employee save(Employee emp) {
		// TODO Auto-generated method stub
		return emprepo.save(emp);
	}

	@Override
	public Employee update(Long id, Employee emp) {
		// TODO Auto-generated method stub
		return emprepo.save(emp);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		emprepo.deleteById(id);
	}

}
