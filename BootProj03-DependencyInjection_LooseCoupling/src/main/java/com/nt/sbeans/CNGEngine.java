package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("cngEngg")
public class CNGEngine implements Engine {
	public CNGEngine()
	{
		System.out.println("CNG Engine:: 0-param Constructor");
	}

	@Override
	public void start() {
		System.out.println("CNG Engine Start()");

	}

	@Override
	public void stop() {
		System.out.println("CNG Engine stop()");

	}

}
