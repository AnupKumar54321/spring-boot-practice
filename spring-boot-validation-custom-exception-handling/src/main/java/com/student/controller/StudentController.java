package com.student.controller;

import com.student.entity.StudentEntity;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @PostMapping("/create")
    public ResponseEntity<?> createStudent(@RequestBody @Valid StudentEntity studentEntity) {
        return new ResponseEntity<>(studentService.createStudent(studentEntity), HttpStatus.CREATED);
    }
    @GetMapping("/details/{id}")
    public ResponseEntity<?> createStudent(@PathVariable("id") String id) {
        return new ResponseEntity<>(studentService.details(id), HttpStatus.OK);
    }
}
