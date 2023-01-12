package com.exam.test.repository;

import com.exam.test.dto.EmployeeDTO;
import com.exam.test.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(name = "getAllEmployeesYearlySalary", nativeQuery = true)
    List<EmployeeDTO> getAllEmployeesYearlySalary();
}
