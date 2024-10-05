package com.nt.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceClient {
	@Autowired
	private LoadBalancerClient client;
	
	public String billingServiceClient(){
		
		System.out.println("Client Component Class Name:: "+ client.getClass());
		//Get the less Load Factor of Provider MicroServices(Billing Service) by giving its Service ID
		ServiceInstance instance = client.choose("Billing-Service");
		//Get details about provider MS from the Service Instance
		String url = instance.getUri()+"/billing_service/details";
		//Use RestTemplate For Communication
		RestTemplate template = new RestTemplate();
		String result = template.getForObject(url, String.class);
		return result;
	}

}
