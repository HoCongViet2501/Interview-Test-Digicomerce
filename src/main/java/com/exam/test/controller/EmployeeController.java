package com.exam.test.controller;

import com.exam.test.dto.EmployeeDTO;
import com.exam.test.model.Developer;
import com.exam.test.model.Tester;
import com.exam.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    
    private final EmployeeService employeeService;
    
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @GetMapping("/save5Developers")
    public ResponseEntity<List<Developer>> save5Developers() {
        return ResponseEntity.ok().body(employeeService.save5Developers());
    }
    
    @GetMapping("/save5Testers")
    public ResponseEntity<List<Tester>> save5Testers() {
        return ResponseEntity.ok().body(employeeService.save5Testers());
    }
    
    @GetMapping("/getAllEmployeesYearlySalary")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployeesYearlySalary() {
        return ResponseEntity.ok().body(employeeService.getAllEmployeesYearlySalary());
    }
    
}
