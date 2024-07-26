package com.example.employee.service;

import com.example.employee.payload.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto saveOneEmployee(EmployeeDto empDto);

    EmployeeDto getOneEmployee(long id);

    List<EmployeeDto> getAllEmployees();

    void deleteRecord(long id);
}
