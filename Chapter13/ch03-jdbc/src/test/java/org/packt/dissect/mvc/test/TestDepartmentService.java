package org.packt.dissect.mvc.test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.packt.dissect.mvc.context.SpringDbConfig;
import org.packt.dissect.mvc.dao.DepartmentDao;
import org.packt.dissect.mvc.dao.EmployeeDao;
import org.packt.dissect.mvc.dao.impl.EmployeeDaoImpl;
import org.packt.dissect.mvc.dispatcher.SpringDispatcherConfig;
import org.packt.dissect.mvc.model.data.Employee;
import org.packt.dissect.mvc.service.EmployeeService;
import org.packt.dissect.mvc.service.impl.EmployeeServiceImpl;
import org.packt.dissect.mvc.webxml.SpringWebinitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { SpringWebinitializer.class, SpringDbConfig.class, SpringDispatcherConfig.class })
public class TestDepartmentService {
	
	
	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;
	
	@Mock
	private EmployeeDaoImpl employeeDaoImpl;
	
	@Before
	public void setUp(){
	    MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testService(){
		
		List<Employee> emps = new ArrayList<>();
		
		Employee rec1 = new Employee();
		rec1.setId(22);
		rec1.setEmpId(3673);
		rec1.setAge(22);
		rec1.setBirthday(new Date(101,11,1));
		rec1.setDeptId(555);
		rec1.setFirstName("Joanna");
		rec1.setLastName("Kiko");
		
		emps.add(rec1);
		
		given(employeeDaoImpl.getEmployees()).willReturn(emps);
		System.out.println(employeeServiceImpl.readEmployees());
	}
}
