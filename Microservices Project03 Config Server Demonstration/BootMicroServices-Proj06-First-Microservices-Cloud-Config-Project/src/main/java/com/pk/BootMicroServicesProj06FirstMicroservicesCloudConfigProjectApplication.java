package com.pk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BootMicroServicesProj06FirstMicroservicesCloudConfigProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMicroServicesProj06FirstMicroservicesCloudConfigProjectApplication.class, args);
	}

}
