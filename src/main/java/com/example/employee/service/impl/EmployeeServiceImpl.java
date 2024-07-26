package com.example.employee.service.impl;

import com.example.employee.entities.Employee;
import com.example.employee.payload.EmployeeDto;
import com.example.employee.repositories.EmployeeRepository;
import com.example.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository empRepo;

    public EmployeeServiceImpl(EmployeeRepository empRepo) {
        this.empRepo = empRepo;
    }

    @Override
    public EmployeeDto saveOneEmployee(EmployeeDto empDto) {
        Employee emp=mapToEntity(empDto);
        EmployeeDto dto=mapToDto(emp);
        return dto;
    }

    @Override
    public EmployeeDto getOneEmployee(long id) {
        Optional<Employee> emp =empRepo.findById(id);
        Employee employee = emp.get();
        return mapToDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees= empRepo.findAll();
        return employees.stream().map(emp -> mapToDto(emp)).collect(Collectors.toList());
    }

    @Override
    public void deleteRecord(long id) {
        empRepo.deleteById(id);
    }

    private EmployeeDto mapToDto(Employee emp) {
        EmployeeDto dto=new EmployeeDto();
        dto.setId(emp.getId());
        dto.setFirstName(emp.getFirstName());
        dto.setLastName(emp.getLastName());
        dto.setEmail(emp.getEmail());
        dto.setMobile(emp.getMobile());
        return dto;
    }
    private Employee mapToEntity(EmployeeDto empDto) {
        Employee emp=new Employee();
        emp.setFirstName(empDto.getFirstName());
        emp.setLastName(empDto.getLastName());
        emp.setMobile(empDto.getMobile());
        emp.setEmail(empDto.getEmail());
        Employee empEnt = empRepo.save(emp);
        return empEnt;
    }

}
