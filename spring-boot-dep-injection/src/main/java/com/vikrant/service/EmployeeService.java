package com.vikrant.service;

import com.vikrant.bean.Employee;
import com.vikrant.dao.EmployeeDao;

import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDaoDepInjUsingProp;
    private EmployeeDao employeeDaoDepInjUsingConstructor;

    public EmployeeService() {

    }

    public void addEmployee(Employee employee) {
        employeeDaoDepInjUsingProp.addEmployee(employee);
    }

    public List<Employee> getListOfEmployees() {
        return employeeDaoDepInjUsingProp.getListOfEmployees();
    }
}
