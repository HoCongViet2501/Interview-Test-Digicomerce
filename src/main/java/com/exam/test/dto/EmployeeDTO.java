package com.exam.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class EmployeeDTO {
    
    private String empType;
    
    private Long id;
    
    private String lastName; 
    
    private String programmingLanguage;
    
    private Boolean automated;
    
    private Double yearlySalary;
    
}
