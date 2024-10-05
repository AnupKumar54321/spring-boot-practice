package com.nt.srevice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepository;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	private IEmployeeRepository empRepo;

	@Override
	public List<Employee> fetchAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public String registerEmployee(Employee emp) {
		   int idVal = empRepo.save(emp).getEmpno();
		   return "Employee is saved with id Value ::"+idVal;
	}

	@Override
	public Employee searchEmployeeByNo(int no) {
		return empRepo.findById(no).orElseThrow(()-> new IllegalArgumentException("Employee is not found"));
	}

	@Override
	public String modifyEmployee(Employee emp) {
		Optional<Employee> opt=empRepo.findById(emp.getEmpno());
		if(opt.isPresent()) {
			  //update the object
			empRepo.save(emp);
			return emp.getEmpno() +" --> Employee details are updated";
		}
		return emp.getEmpno() +" --> Employee is not found";
	}

	@Override
	public String deleteEmployee(int no) {
		Optional<Employee> opt = empRepo.findById(no);
		if(opt.isPresent())
		{
			empRepo.deleteById(no);
			return no +" id is deleted";
		}
		return no+" not found for deletion";
	}

	}


