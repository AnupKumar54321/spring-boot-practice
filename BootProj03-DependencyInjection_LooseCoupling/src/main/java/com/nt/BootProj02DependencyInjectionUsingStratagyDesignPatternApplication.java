package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.sbeans.Vehicle;

@SpringBootApplication
@ImportResource("com/nt/config/applicationContext.xml")
public class BootProj02DependencyInjectionUsingStratagyDesignPatternApplication {

	public static void main(String[] args) {
		//Get the IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj02DependencyInjectionUsingStratagyDesignPatternApplication.class, args);
		//Get the target class Object
		Vehicle vehicle =  ctx.getBean("vehicle", Vehicle.class);
		//invoke the business method
		vehicle.move("Bhubaneswar", "Umerkote");
		//close the container
		((ConfigurableApplicationContext) ctx).close();
		
	}

}
