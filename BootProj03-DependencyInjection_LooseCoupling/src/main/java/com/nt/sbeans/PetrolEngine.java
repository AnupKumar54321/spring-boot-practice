package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("pEngg")
public class PetrolEngine implements Engine {
	public PetrolEngine()
	{
		System.out.println("Petrol Engine:: 0-param Constructor");
	}
  
	@Override
	public void start() {
		System.out.println("Petrol Engine Start()");

	}

	@Override
	public void stop() {
		System.out.println("Petrol Engine stop()");

	}

}
