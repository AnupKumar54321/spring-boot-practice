package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nt.entity.Employee;
import com.nt.srevice.IEmployeeMgmtService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class EmployeeOperationsController {
	
	@Autowired
	private IEmployeeMgmtService empService;
	
	@GetMapping("/")
	public String showHomePage()
	{
		//Return the LVN
	    return "welcome";	
	 }
	
	@GetMapping("/report")
	public String showReport(Map<String, Object> map)
	{
		//Invoke the service class method
		List<Employee> list = empService.fetchAllEmployees();
		//Keep the result in the model Attribute
		map.put("empList", list);
		System.out.println("EmployeeOperationsController.showReport()");
		//return LVN
		return "show_report";
	}
	
	@GetMapping("/register")
	public String addEmployeeFormPage(@ModelAttribute("emp") Employee emp)
	{
		//return LVN
		return "add_employee";
	}
	
	@PostMapping("/register")
	public String registerEmployee(Map<String, Object> map,@ModelAttribute("emp") Employee emp) {
		String result=empService.registerEmployee(emp);
		List<Employee> listemp = empService.fetchAllEmployees();
		//keep the result in the model attribute
		map.put("resultMsg", result);
		map.put("empList", listemp);
		//return LVN
		return "show_report";
	}
	
	
	@GetMapping("/edit")  //for  edit form launch
	public   String showEditFormPage(@ModelAttribute("emp") Employee emp,@RequestParam("no") int no) {
		// use the service
		Employee  emp1=empService.searchEmployeeByNo(no);
		//copy received emp1 obj  data to   Model class object
		BeanUtils.copyProperties(emp1, emp);  //copies  emp1 obj data emp obj
		//return LVN
		return "edit_employee_form";
	}
	
	
	@PostMapping("/edit")  //for edit form submission
	public  String  editEmployee(RedirectAttributes  attrs,  @ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeOperationsController.registerEmployee()");
		//use the service
		String result=empService.modifyEmployee(emp);
		//keep the result in RedirectAttributes Shared Memory  as the FlashAttributes
		attrs.addFlashAttribute("resultMsg", result);
		//return LVN
		return "redirect:report";
	}
	
	@GetMapping("/delete")
	public String deleteEmployeeById(@RequestParam("no") int no, RedirectAttributes attrs) {
		
		String result=empService.deleteEmployee(no);
		attrs.addFlashAttribute("resultMsg",result);
		return "redirect:report";
	}
	
	@GetMapping("/pagination")
	public String showReportByPagination(@PageableDefault(page = 0,size = 4,sort = "empname",direction = Sort.Direction.ASC) Pageable pageable,
			                                                                          Map<String, Object> map) {
		System.out.println("Method Started");
		Page<Employee> result = empService.fetchAllEmployeesBypage(pageable);
		//Now put the result inside the model attribute
		map.put("pageDetails", result);
		//return LVN
		return "show_report1";
		
	}

}
