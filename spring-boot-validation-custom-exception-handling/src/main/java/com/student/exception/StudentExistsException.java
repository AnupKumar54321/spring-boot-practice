package com.student.exception;

public class StudentExistsException extends RuntimeException{
    public StudentExistsException(String msg) {
        super(msg);
    }
}
