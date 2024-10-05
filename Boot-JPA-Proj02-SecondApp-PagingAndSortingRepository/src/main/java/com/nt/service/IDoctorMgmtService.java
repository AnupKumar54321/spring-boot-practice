package com.nt.service;

import org.springframework.data.domain.Page;

import com.nt.entity.Doctor;

public interface IDoctorMgmtService {
	public Iterable<Doctor> showDoctorsInSorting(boolean ascOrder, String... properties);
	public Page<Doctor> showDoctorPagination(int pageNo,int pageSize,boolean ascOrder, String... properties);
	public void showDoctorPageByPage(int pageSize);

}
