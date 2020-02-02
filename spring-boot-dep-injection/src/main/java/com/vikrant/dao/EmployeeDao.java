package com.vikrant.dao;

import com.vikrant.bean.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    List<Employee> listOfEmployees = new ArrayList<Employee>();

    public void addEmployee(Employee employee) {
        listOfEmployees.add(employee);
    }

    public List<Employee> getListOfEmployees() {
        return listOfEmployees;
    }

}
