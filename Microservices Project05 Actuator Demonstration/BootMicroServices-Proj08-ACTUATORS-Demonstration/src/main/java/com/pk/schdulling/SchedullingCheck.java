package com.pk.schdulling;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedullingCheck {
	
	@Scheduled(cron = "15 * * * * *")
	public void displayReport() {
		System.out.println("The System date is "+new Date());
	}

}
