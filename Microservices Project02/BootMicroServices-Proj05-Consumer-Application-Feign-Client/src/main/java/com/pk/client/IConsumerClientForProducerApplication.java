package com.pk.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("Producer-application-Feign-Client")
public interface IConsumerClientForProducerApplication {
	
	@GetMapping("/billing_service/details")
	public ResponseEntity<String> getBillingDetails();

}
