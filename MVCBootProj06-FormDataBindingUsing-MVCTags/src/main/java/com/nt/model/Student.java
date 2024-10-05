package com.nt.model;

import lombok.Data;

@Data
public class Student {
	private int sno;
	private String  sname;
	private String sadd="Bhubaneswar";
	private Float avg;
	
	
public Student(){
	System.out.println("Student.enclosing_method()"+this);

}
}

