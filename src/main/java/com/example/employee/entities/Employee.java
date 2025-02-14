package com.example.employee.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employees",
       uniqueConstraints = {@UniqueConstraint(columnNames = {"email","mobile"})})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="first_name",nullable = false)
    private String firstName;
    @Column(name="last_name",nullable = false)
    private String lastName;
    @Column(name="email",nullable = false)
    private String email;
    @Column(name="mobile",nullable = false)
    private long mobile;
}
