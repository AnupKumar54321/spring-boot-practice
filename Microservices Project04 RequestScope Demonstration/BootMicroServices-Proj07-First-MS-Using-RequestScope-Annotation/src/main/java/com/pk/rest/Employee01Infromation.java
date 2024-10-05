package com.pk.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@RefreshScope
public class Employee01Infromation {
	
	@Value("${user_name}")
	private String username;
	@Value("${user_password}")
	private String password;
	
	@GetMapping("/details")
	public String getDetails() {
		return "The Username: "+username+" password: "+password;
	}

}
