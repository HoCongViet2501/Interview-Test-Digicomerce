package com.exam.test.model;

import com.exam.test.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@NamedNativeQuery(name = "getAllEmployeesYearlySalary",
        query = "select e.emp_type as empType , e.id ,e.last_name as lastName ,e.programming_language as programmingLanguage ,e.automated, (e.monthly_salary*12) as yearlySalary  from employee e ",
        resultSetMapping = "EmployeeDTO")
@SqlResultSetMapping(name = "EmployeeDTO",
        classes = @ConstructorResult(
                targetClass = EmployeeDTO.class,
                columns = {
                        @ColumnResult(name = "empType", type = String.class),
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "lastName", type = String.class),
                        @ColumnResult(name = "programmingLanguage", type = String.class),
                        @ColumnResult(name = "automated", type = Boolean.class),
                        @ColumnResult(name = "yearlySalary", type = Double.class)
                }
        ))

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "emp_type")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    
    @Column(name = "last_name")
    protected String lastName;
    
    @Column(name = "monthly_salary")
    protected Double monthlySalary;
    
}
