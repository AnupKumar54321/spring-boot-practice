package com.nt;

import java.io.PrintStream;
import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.SeasonFinder;

@SpringBootApplication
public class BootProj01DependencyInjectionApplication {

	@Bean(name ="id")
	public LocalDate createLDT()
	{
		System.out.println("BootProj01DependencyInjectionApplication.createLDT()");
		return LocalDate.now();//Gives LocalDate class objecthaving System date and tim	
	}
	
	public static void main(String[] args) {
		//get IOC Container
		ApplicationContext ctx = SpringApplication.run(BootProj01DependencyInjectionApplication.class, args);
		//get Target spring bean class object
		SeasonFinder finder = ctx.getBean("sf",SeasonFinder.class);
		//Invoke the Business method
		
		String msg= finder.showSeasonName();
		System.out.println("Result:: "+msg);
		
		//Close the IOC Container
		((ConfigurableApplicationContext) ctx).close();
	}

}
