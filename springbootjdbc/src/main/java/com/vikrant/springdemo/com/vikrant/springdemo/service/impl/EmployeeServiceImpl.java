package com.vikrant.springdemo.com.vikrant.springdemo.service.impl;

import com.vikrant.springdemo.dao.EmployeeDao;
import com.vikrant.springdemo.model.Employee;
import com.vikrant.springdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;


    @Override
    public void insertEmployee(Employee emp) {
        employeeDao.insertEmployee(emp);
    }

    @Override
    public void insertEmployees(List<Employee> employees) {
        employeeDao.insertEmployees(employees);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(String empid) {
        return employeeDao.getEmployeeById(empid);
    }
}
