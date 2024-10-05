package com.pk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BootMicroServicesProj07FirstMsUsingRequestScopeAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMicroServicesProj07FirstMsUsingRequestScopeAnnotationApplication.class, args);
	}

}
