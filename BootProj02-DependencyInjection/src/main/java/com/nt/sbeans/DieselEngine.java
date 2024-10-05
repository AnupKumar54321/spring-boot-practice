package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("dEngg")
public class DieselEngine implements Engine {
	public DieselEngine()
	{
		System.out.println("Diesel Engine:: 0-param Constructor");
	}
  
	@Override
	public void start() {
		System.out.println("Diesel Engine Start()");

	}

	@Override
	public void stop() {
		System.out.println("Diesel Engine stop()");

	}

}
