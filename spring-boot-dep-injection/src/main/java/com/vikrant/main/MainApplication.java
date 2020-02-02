package com.vikrant.main;

import com.vikrant.bean.Employee;
import com.vikrant.service.EmployeeService;

import java.util.List;

public class MainApplication {

    public static void main(String[] args) {



        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        EmployeeService employeeService = new EmployeeService();

        Employee emp1 = new Employee("1", "Test1", "Manager", 1000);
        Employee emp2 = new Employee("1", "Test2", "Manager", 1000);
        Employee emp3 = new Employee("1", "Test3", "Manager", 1000);
        Employee emp4 = new Employee("1", "Test4", "Manager", 1000);
        Employee emp5 = new Employee("1", "Test5", "Manager", 1000);

        employeeService.addEmployee(emp1);
        employeeService.addEmployee(emp2);
        employeeService.addEmployee(emp3);
        employeeService.addEmployee(emp4);
        employeeService.addEmployee(emp5);
        List<Employee> employees = employeeService.getListOfEmployees();
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }

    }
}
