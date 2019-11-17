package com.project.az.springbootrest;

import static org.junit.Assert.*;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.az.springbootrest.dao.EmployeeRepository;
import com.project.az.springbootrest.models.Employee;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class SpringbootrestApplicationTests {
	
	@Autowired
	EmployeeRepository emprep;
	
	@Test
	public void testDAORepo() {
		Optional<Employee> emp = emprep.findByName("Karin");
		assertTrue(emp.get() instanceof Employee);
		assertThat(emp.get(), instanceOf(Employee.class));
		assertThat(emp.get().getEmail(), equalTo("karin@email.com"));
	}

	
}
