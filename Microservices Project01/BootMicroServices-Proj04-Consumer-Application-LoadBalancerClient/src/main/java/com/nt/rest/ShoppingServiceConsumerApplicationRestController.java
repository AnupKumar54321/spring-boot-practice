package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.BillingServiceClient;

@RestController
@RequestMapping("/consumer")
public class ShoppingServiceConsumerApplicationRestController {
	
	@Autowired
	private BillingServiceClient billClient;
	
	@GetMapping("/service")
	public ResponseEntity<String> shoppingDetails(){
		String result = billClient.billingServiceClient();
		return new ResponseEntity<String>("The total Bill of your purchased Items is "+ result,HttpStatus.OK);
	}

}
