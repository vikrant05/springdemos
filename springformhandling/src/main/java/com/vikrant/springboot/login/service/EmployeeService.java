package com.vikrant.springboot.login.service;

import com.vikrant.springboot.login.dao.EmployeeDao;
import com.vikrant.springboot.login.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface EmployeeService {
    void insertEmployee(Employee emp) throws Exception;

    void insertEmployees(List<Employee> employees);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String empid);
}
