//Target Class
package com.nt.sbeans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public class Vehicle {
	@Autowired
	@Qualifier("eEngg")
	private Engine engine;
	public Vehicle()
	{
		System.out.println("Vehicle:: 0-ParamConstructor");
	}
	
	public void move(String sourcePlace, String destPlace) {
		engine.start();
		System.out.println("Journey Started from ::"+sourcePlace);
		System.out.println("Journey is going on.......");
		engine.stop();
		System.out.println("Journey Stopped at::"+destPlace);
		
	}

}
