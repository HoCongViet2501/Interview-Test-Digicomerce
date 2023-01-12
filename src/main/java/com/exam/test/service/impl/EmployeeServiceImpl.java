package com.exam.test.service.impl;

import com.exam.test.dto.EmployeeDTO;
import com.exam.test.model.Developer;
import com.exam.test.model.Employee;
import com.exam.test.model.Tester;
import com.exam.test.repository.DeveloperRepository;
import com.exam.test.repository.EmployeeRepository;
import com.exam.test.repository.TesterRepository;
import com.exam.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    private final DeveloperRepository developerRepository;
    
    private final TesterRepository testerRepository;
    
    private final EmployeeRepository employeeRepository;
    
    @Autowired
    public EmployeeServiceImpl(DeveloperRepository developerRepository, TesterRepository testerRepository, EmployeeRepository employeeRepository) {
        this.developerRepository = developerRepository;
        this.testerRepository = testerRepository;
        this.employeeRepository = employeeRepository;
    }
    
    @Override
    public List<Developer> save5Developers() {
        List<Developer> developers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Developer developer = new Developer();
            developer.setLastName("Developer " + i + 1);
            developer.setProgrammingLanguage("Java");
            developer.setMonthlySalary(1000000.0);
            developers.add(developer);
        }
        return developerRepository.saveAll(developers);
    }
    
    @Override
    public List<Tester> save5Testers() {
        List<Tester> testers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tester tester = new Tester();
            tester.setLastName("Tester " + i + 1);
            tester.setMonthlySalary(1000000.0);
            tester.setAutomated(true);
            testers.add(tester);
        }
        return testerRepository.saveAll(testers);
    }
    
    @Override
    public List<EmployeeDTO> getAllEmployeesYearlySalary() {
        return employeeRepository.getAllEmployeesYearlySalary();
    }
    
    @Override
    public List<Employee> raise10PercentSalary() {
        List<Employee> employees = employeeRepository.findAll();
        employees.forEach(employee -> employee.setMonthlySalary(employee.getMonthlySalary() * 1.1));
        return employeeRepository.saveAll(employees);
    }
    
    @Override
    public List<Employee> delete2lowestSalary() {
        List<Employee> employees = employeeRepository.findAll();
        employees.sort((o1, o2) -> (int) (o1.getMonthlySalary() - o2.getMonthlySalary()));
        this.employeeRepository.delete(employees.get(0));
        this.employeeRepository.delete(employees.get(1));
        employees.remove(0);
        employees.remove(0);
        return employees;
    }
    
}
