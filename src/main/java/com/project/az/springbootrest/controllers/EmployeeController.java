package com.project.az.springbootrest.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.az.springbootrest.models.Employee;
import com.project.az.springbootrest.services.IEmployeeService;

@RestController
@RequestMapping(value="/api")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService empservice;

	public EmployeeController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/employee/{name}", method=RequestMethod.GET)
	public ResponseEntity<Employee> getEmployeeByName(@PathVariable String name){
		
		Optional<Employee> emp = empservice.findByName(name);
		if(emp.isPresent()){
			return new ResponseEntity<Employee>(emp.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}

}
