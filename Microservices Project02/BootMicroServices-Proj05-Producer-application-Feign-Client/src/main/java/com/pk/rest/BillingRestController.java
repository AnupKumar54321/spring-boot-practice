package com.pk.rest;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing_service")
public class BillingRestController {
	
	@Value("${server.port}")
	private int portNumber;
	@Value("${eureka.instance.instance-id}")
	private String instanceId;
	
	@GetMapping("/details")
	public ResponseEntity<String> billingService() {
		int billAmount = new Random().nextInt(40000);
		return new ResponseEntity<String>(billAmount+"-------"+
		                                                                        "The Port number = "+portNumber+"    The instance Id "+instanceId,HttpStatus.OK);
	}

}
