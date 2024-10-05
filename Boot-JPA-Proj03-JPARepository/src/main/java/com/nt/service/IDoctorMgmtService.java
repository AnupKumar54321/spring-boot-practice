package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nt.entity.Doctor;

public interface IDoctorMgmtService {
	public String removeDoctorsInBatchByIds(List<Integer> ids);

}
