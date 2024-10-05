package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Student;

@Controller
public class StudentsOperationController {
	
	@GetMapping("/")
	public String showHomePage()
	{
		System.out.println("StudentsOperationController.showHomePage()");
		//Return LVN
		return "welcome";
	}
	
	@GetMapping("/register")
	public String showFormPage(@ModelAttribute("stud") Student st) {
		System.out.println("StudentsOperationController.showFormPage()");
		//return LVN ------- Form page
		return "show_form";
	}
	
	@PostMapping("/register")
	public String registerStudent(Map<String,Object> map,@ModelAttribute("stud1") Student st) {
		System.out.println("Model class obj data:: "+st);
		//Business Logics
		String result=null;
		if(st.getAvg()<=35)
			result="FAIL";
		else
			result="PASS";
		//Keep Result, model class obj in shared memory as the model Attributes
		map.put("resultMsg", result);
		map.put("formData", st);
		
		//Return LVN
		return "show_result";
	}

}
