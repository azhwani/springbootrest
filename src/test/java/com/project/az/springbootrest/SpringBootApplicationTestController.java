package com.project.az.springbootrest;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.project.az.springbootrest.models.Employee;
import com.project.az.springbootrest.services.IEmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SpringBootApplicationTestController {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private IEmployeeService empservice;
	
	@Before
    public void init() {
       
		Employee emp01 = new Employee();
		emp01.setName("samantha");
		emp01.setEmail("samantha@gmail.com");
		Optional<Employee> emp = Optional.of(emp01);

	    Mockito.when(empservice.findByName(emp01.getName())).thenReturn(emp);
		
    }
	
	@Test
	public void TestEmployeeOK()
	  throws Exception {

	    mvc.perform(get("/api/employeebyname/samantha").contentType(MediaType.APPLICATION_JSON))
	       .andExpect(status().isOk())
	       .andExpect(jsonPath("$.email").value("samantha@gmail.com"));
	}
	
	@Test
	public void TestNotFoundEmployee()
	  throws Exception {
	     
		Employee emp01 = new Employee();
		emp01.setName("ssamantha");
		emp01.setEmail("samantha@gmail.com");
		Optional<Employee> emp = Optional.of(emp01);

	    Mockito.when(empservice.findByName(emp01.getName())).thenReturn(emp);
	 
	    mvc.perform(get("/api/employeebyname/sSamantha").contentType(MediaType.APPLICATION_JSON))
	       .andExpect(status().isNotFound());
	}
	

}
