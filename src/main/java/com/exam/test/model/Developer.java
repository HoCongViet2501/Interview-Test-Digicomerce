package com.exam.test.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "developer")
@Entity
public class Developer extends Employee {
    @Column(name = "programming_language", nullable = false)
    private String programmingLanguage;
}
