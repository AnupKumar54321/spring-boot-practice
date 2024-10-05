package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("eEngg")
public class ElectricEngine implements Engine {
	public ElectricEngine()
	{
		System.out.println("Electric Engine:: 0-param Constructor");
	}

	@Override
	public void start() {
		System.out.println("Electric Engine Start()");

	}

	@Override
	public void stop() {
		System.out.println("Electric Engine stop()");

	}

}
