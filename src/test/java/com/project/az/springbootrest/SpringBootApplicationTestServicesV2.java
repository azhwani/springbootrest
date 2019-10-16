package com.project.az.springbootrest;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.az.springbootrest.dao.EmployeeRepository;
import com.project.az.springbootrest.models.Employee;
import com.project.az.springbootrest.services.EmployeeService;
import com.project.az.springbootrest.services.IEmployeeService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
public class SpringBootApplicationTestServicesV2 {

	@TestConfiguration
    static class EmployeeServiceTestContextConfiguration {
        @Bean
        public EmployeeService employeeService() {
            return new EmployeeService();
        }
    }
 
    @Autowired
	IEmployeeService empservice;
	
	@MockBean
	EmployeeRepository emprep;
	
	@Before
    public void init() {
       
		Employee emp01 = new Employee();
		emp01.setName("Samantha");
		emp01.setEmail("samantha@gmail.com");
		Optional<Employee> emp = Optional.of(emp01);

	    Mockito.when(emprep.findByName(emp01.getName())).thenReturn(emp);
		
    }
	
	@Test
	public void testService() {
		
		Optional<Employee> emp = empservice.findByName("Samantha");
		assertThat(emp.get().getEmail(), equalTo("samantha@gmail.com"));
		
	}
	

}
