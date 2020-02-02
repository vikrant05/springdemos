package com.vikrant.springboot.login.service.impl;

import com.vikrant.springboot.login.dao.EmployeeDao;
import com.vikrant.springboot.login.model.Employee;
import com.vikrant.springboot.login.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;


    @Override
    public void insertEmployee(Employee emp) throws Exception {
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
