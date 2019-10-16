package com.project.az.springbootrest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value="/employees", method=RequestMethod.GET)
	public List<Employee> getAll(){
		
		List<Employee> emps = empservice.getAllEmployees();
		return emps;
	}
	
	@RequestMapping(value="/employee/{id}", method=RequestMethod.GET)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
		
		Optional<Employee> emp = empservice.findById(id);
		if(emp.isPresent()){
			return new ResponseEntity<Employee>(emp.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/employeeby/{name}", method=RequestMethod.GET)
	public ResponseEntity<Employee> getEmployeeByName(@PathVariable String name){
		
		Optional<Employee> emp = empservice.findByName(name);
		if(emp.isPresent()){
			return new ResponseEntity<Employee>(emp.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/employeeby/{email}", method=RequestMethod.GET)
	public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable String email){
		
		Optional<Employee> emp = empservice.getEmployeeByEmail(email);
		if(emp.isPresent()){
			return new ResponseEntity<Employee>(emp.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/employees", method=RequestMethod.POST)
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
		return new ResponseEntity<Employee>(empservice.save(emp), HttpStatus.OK);
	}
	
	@RequestMapping(value="/employee/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee emp){
		Optional<Employee> gemp = empservice.findById(id);
		if(gemp.isPresent()){
			return new ResponseEntity<Employee>(empservice.save(emp), HttpStatus.OK);
		}
		
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND); 
	}
	
	@RequestMapping(value="/employee/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int id){
		Optional<Employee> gemp = empservice.findById(id);
		if(gemp.isPresent()){
			empservice.delete(id);
			return new ResponseEntity<Employee>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
}
