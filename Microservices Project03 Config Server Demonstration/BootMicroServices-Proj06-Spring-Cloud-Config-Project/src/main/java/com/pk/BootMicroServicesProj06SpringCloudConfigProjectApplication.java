package com.pk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class BootMicroServicesProj06SpringCloudConfigProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMicroServicesProj06SpringCloudConfigProjectApplication.class, args);
	}

}
