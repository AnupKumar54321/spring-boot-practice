package com.nt.service;

import org.springframework.data.domain.Page;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;

@Service("docService")
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {

	@Autowired
	private IDoctorRepository doctorRepo;
	
	@Override
	public Iterable<Doctor> showDoctorsInSorting(boolean ascOrder, String ...properties) {
		
		//Create The Sort Object
		Sort sort=Sort.by(ascOrder? Sort.Direction.ASC : Sort.Direction.DESC, properties);
		//Use the Repo
		Iterable<Doctor> it  = doctorRepo.findAll(sort);
		return it;
	}

	@Override
	public Page<Doctor> showDoctorPagination(int pageNo, int pageSize, boolean ascOrder, String... properties) {

		// Create The Sort Object
		Sort sort = Sort.by(ascOrder ? Sort.Direction.ASC : Sort.Direction.DESC, properties);
		// Create the Pageable Object
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		//Use Repo
		Page<Doctor> page= doctorRepo.findAll(pageable);
		return page;
	}

	@Override
	public void showDoctorPageByPage(int pageSize) {
		//Get total record count
		long count=doctorRepo.count();
		//Get no of pages
		long pagesCount=count/pageSize;
		if(count%pageSize!=0)
		{
			pagesCount++;
		}
	    for (int i = 0; i < pageSize; i++) {
	    	//Create Pageable object
	    	Pageable pageable = PageRequest.of(i, pageSize);
	    	//use repo
	    	Page<Doctor> page=doctorRepo.findAll(pageable);
	    	System.out.println("--------------Records of the "+(page.getNumber()+1)+"/"+page.getTotalPages()+" page--------------");
			page.getContent().forEach(System.out::println);
		}
		
	}

}
