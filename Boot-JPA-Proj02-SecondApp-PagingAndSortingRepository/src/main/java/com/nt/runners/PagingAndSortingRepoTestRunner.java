package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorMgmtService;

@Component
public class PagingAndSortingRepoTestRunner implements CommandLineRunner{

	@Autowired
	private IDoctorMgmtService docService;
	
	@Override
	public void run(String... args) throws Exception {
		/*	try {
				docService.showDoctorsInSorting(true,"docName").forEach(System.out::println);
			} catch (Exception e) {
				e.printStackTrace();
			}*/
		/*	
			try {
				Page<Doctor> page=docService.showDoctorPagination(3, 3, true, "docName");
				page.getContent().forEach(System.out::println);
				System.out.println("Current Page Number:: "+page.getNumber()+"/"+page.getTotalPages());
				System.out.println("Total Number of Records in the current page:: "+page.getNumberOfElements());
				System.out.println("Total Number Of records:: "+page.getTotalElements());
				System.out.println("Is It the First page:: "+page.isFirst());
				System.out.println("IS it the Last page:: "+page.isLast());
				System.out.println("Is it an empty page:: "+page.isEmpty());
			} catch (Exception e) {
				e.printStackTrace();
			}*/
		
		
		try {
			//use service
			docService.showDoctorPageByPage(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
