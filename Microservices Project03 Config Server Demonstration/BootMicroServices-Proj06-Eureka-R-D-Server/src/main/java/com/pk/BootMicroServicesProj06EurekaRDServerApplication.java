package com.pk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BootMicroServicesProj06EurekaRDServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMicroServicesProj06EurekaRDServerApplication.class, args);
	}

}
