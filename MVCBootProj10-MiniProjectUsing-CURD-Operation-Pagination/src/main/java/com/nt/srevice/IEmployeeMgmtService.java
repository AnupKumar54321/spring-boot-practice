package com.nt.srevice;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.entity.Employee;

public interface IEmployeeMgmtService {
	
	public List<Employee> fetchAllEmployees();
	public String registerEmployee(Employee emp);
	public Employee searchEmployeeByNo(int no);
	public  String  modifyEmployee(Employee emp);
	public String deleteEmployee(int no);
	public Page<Employee> fetchAllEmployeesBypage(Pageable pageable);

}
