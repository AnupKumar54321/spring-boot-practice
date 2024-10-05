package com.nt.service;

import org.springframework.data.domain.Page;

import java.util.Iterator;
import java.util.List;

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
	public String removeDoctorsInBatchByIds(List<Integer> ids) {
		//Use Repo
		List<Doctor> list = doctorRepo.findAllById(ids);
		//Use Repo
		doctorRepo.deleteAllByIdInBatch(ids);
		return list.size()+" no of records are deleted";
	}
	
	

}
