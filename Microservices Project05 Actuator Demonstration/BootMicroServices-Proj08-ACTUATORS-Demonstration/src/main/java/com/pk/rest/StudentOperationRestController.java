package com.pk.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentOperationRestController {
	
	@GetMapping("/details")
	public String studentDetails() {
		int sid = 90;
		String sname = "Anup Kumar Sahoo";
		return "The student id and student name is  "+sid+"-------"+sname+"   respectively";
	}

}
