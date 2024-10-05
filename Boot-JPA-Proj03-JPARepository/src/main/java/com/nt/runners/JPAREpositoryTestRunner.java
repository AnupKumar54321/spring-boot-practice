package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorMgmtService;

@Component
public class JPAREpositoryTestRunner implements CommandLineRunner{

	@Autowired
	private IDoctorMgmtService docService;

	@Override
	public void run(String... args) throws Exception {
		try {
			String msg= docService.removeDoctorsInBatchByIds(List.of(1,52,1000));
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
