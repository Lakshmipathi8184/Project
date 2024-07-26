package com.example.employee.payload;

import lombok.Data;

@Data
public class EmployeeDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private long mobile;
}
