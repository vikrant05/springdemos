package com.vikrant.springboot.login.dao;

import com.vikrant.springboot.login.model.Employee;

import java.util.List;

public interface EmployeeDao {
    void insertEmployee(Employee cus) throws Exception;

    void insertEmployees(List<Employee> employees);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String empId);
}
