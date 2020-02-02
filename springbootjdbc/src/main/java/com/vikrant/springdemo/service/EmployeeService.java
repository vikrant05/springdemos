package com.vikrant.springdemo.service;

import com.vikrant.springdemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface EmployeeService {
    void insertEmployee(Employee emp);

    void insertEmployees(List<Employee> employees);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String empid);
}
