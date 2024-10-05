package com.student.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
@Table(name = "STUDENT")
@Data
public class StudentEntity implements Serializable {

    @Id
    private String studentId;
    @NotNull(message = "cannot be null")
    @NotBlank(message = "cannot be empty")
    @NotEmpty(message = "first name cannot be null")
    private String firstName;
    @NotNull (message = "cannot be null")
    @NotBlank(message = "cannot be empty")
    @NotEmpty(message = "last name cannot be null")
    private String lastName;

    private String middleName;
    @Min(value = 5,message = "cannot be less than ")
    @Max(value = 99,message = "cannot exceeds from ")
    private int age;
    @Email(message = "invalid email")
    private String email;
    @NotNull (message = "cannot be null")
    @NotBlank(message = "cannot be empty")
    @Pattern(regexp = "^\\d{10}$",message = "invalid phone number")
    private String phoneNumber;
}
