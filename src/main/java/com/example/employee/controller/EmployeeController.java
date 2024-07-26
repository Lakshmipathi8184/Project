package com.example.employee.controller;

import com.example.employee.payload.EmployeeDto;
import com.example.employee.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    public EmployeeController(EmployeeService empService) {
        this.empService = empService;
    }

    private EmployeeService empService;
    @PostMapping
    public ResponseEntity<EmployeeDto> createOneEmployee(@RequestBody EmployeeDto empDto){
        return  new ResponseEntity<>(empService.saveOneEmployee(empDto), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public EmployeeDto getOneEmployee(@PathVariable("id")long id){
        return  empService.getOneEmployee(id);
    }

    @GetMapping
    public List<EmployeeDto> getAllEmployees(){
        return empService.getAllEmployees();
    }
    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable("id")long id){
         empService.deleteRecord(id);
    }

}
