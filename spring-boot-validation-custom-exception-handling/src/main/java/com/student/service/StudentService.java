package com.student.service;

import com.student.entity.StudentEntity;

public interface StudentService {

    public StudentEntity createStudent(StudentEntity studentEntity);
    public StudentEntity details(String id);
}
