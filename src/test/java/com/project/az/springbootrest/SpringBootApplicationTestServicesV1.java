package com.project.az.springbootrest;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.project.az.springbootrest.dao.EmployeeRepository;
import com.project.az.springbootrest.models.Employee;
import com.project.az.springbootrest.services.EmployeeService;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(MockitoJUnitRunner.class)
public class SpringBootApplicationTestServicesV1 {

	@InjectMocks
	EmployeeService empservice;
	
	@Mock
	EmployeeRepository emprep;
	
	@Before
    public void init() {
		Employee emp01 = new Employee();
		emp01.setEmail("abc@gmail.com");
		Optional<Employee> emp = Optional.of(emp01);
		Mockito.when(emprep.findByName("Gupta")).thenReturn(emp);
    }
	
	
	@Test
	public void testService() {
		
		Optional<Employee> emp2 = empservice.findByName("Gupta");
		assertThat(emp2.get().getEmail(), equalTo("abc@gmail.com"));
		
	}

}
