package com.nt.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepository;
import com.nt.srevice.EmployeeMgmtServiceImpl;

@ExtendWith(SpringExtension.class)
public class TestEmployeeMgmtServiceImpl {
	
	
	@InjectMocks
	EmployeeMgmtServiceImpl serviceImpl;
	
	@Mock
	private IEmployeeRepository emplRepo;
	
		@Test
		public void testFetchAllEmployee() {
			List<Employee> empList = new ArrayList<Employee>();
			when(emplRepo.findAll()).thenReturn(empList);
			assertEquals(empList, serviceImpl.fetchAllEmployees());	
		}
		
	@Test
	public void testRegisterEmployee() {
		//Employee empInformation = new Employee();
		int x = employeeData().getEmpno();
	     when(emplRepo.save(any(Employee.class))).thenReturn(employeeData());
		//doReturn(employeeData()).when(emplRepo.save(any(Employee.class)));
	    //String result = serviceImpl.registerEmployee(employeeData());
		assertEquals("Employee is saved with id Value ::2", serviceImpl.registerEmployee(employeeData()));
	}
	
	Employee employeeData() {
		Employee empInformation= new Employee();
		empInformation.setDeptno(10);
		empInformation.setEmpname("Anup");
		empInformation.setEmpno(2);
		empInformation.setJob("Developer");
		empInformation.setSal(7348379849F);
		return empInformation;
	}

}
