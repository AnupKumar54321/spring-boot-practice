package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>,PagingAndSortingRepository<Employee, Integer>{

}

