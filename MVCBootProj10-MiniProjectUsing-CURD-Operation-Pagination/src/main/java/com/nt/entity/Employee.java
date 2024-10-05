package com.nt.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Employee")
public class Employee implements Serializable {
	
	@Id
	@SequenceGenerator(name = "se1",initialValue = 1000,allocationSize = 1,sequenceName = "EMPNO_SEQ")
	@GeneratedValue(generator = "se1",strategy = GenerationType.SEQUENCE)
	private Integer empno;
	@Column(length = 20)
	private String empname;
	@Column(length = 20)
	private String job="Clerk";
	@Column
	private Float sal;
	@Column
	private Integer deptno;

}
