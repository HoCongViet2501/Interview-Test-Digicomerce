package com.exam.test.service;

import com.exam.test.dto.EmployeeDTO;
import com.exam.test.model.Developer;
import com.exam.test.model.Employee;
import com.exam.test.model.Tester;

import java.util.List;

public interface EmployeeService {
    
    List<Developer> save5Developers();
    
    List<Tester> save5Testers();
    
    List<EmployeeDTO> getAllEmployeesYearlySalary();
    
    List<Employee> raise10PercentSalary();
}
