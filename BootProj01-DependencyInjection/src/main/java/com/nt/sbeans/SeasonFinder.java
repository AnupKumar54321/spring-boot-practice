package com.nt.sbeans;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sf")
public class SeasonFinder {
	
	@Autowired  //Field Injection
	private LocalDate ldt; //HAS-A Property
	public SeasonFinder()
	{
		System.out.println("SeasonFinder::0-Param Constructor");
	}
	
	//Write Business method
	
	public String showSeasonName()
	{
		//Get current month value from the injected LocalDate object through ldt
		int month = ldt.getMonthValue();
		//Generate the Season Name 
		if (month>=6&&month<=10)
			return "Rainy Season";
		if(month>=3&&month<=5)
			return "Summer Season";
		else
			return "Winter Season";
		
	}
	
	

}
