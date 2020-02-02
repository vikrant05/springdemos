package com.vikrant.springdemo;

import com.vikrant.springdemo.model.Employee;
import com.vikrant.springdemo.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootJdbcApp {

    //@Autowired
    //EmployeeService employeeService;

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(SpringBootJdbcApp.class, args);

        EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);


        Employee emp = new Employee();
        emp.setEmpId("103");
        emp.setEmpName("emp");

        Employee emp1 = new Employee();
        emp1.setEmpId("104");
        emp1.setEmpName("emp1");

        Employee emp2 = new Employee();
        emp2.setEmpId("105");
        emp2.setEmpName("emp2");

        //employeeService.insertEmployee(emp);

        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        //employeeService.insertEmployees(employees);

        System.out.println(employeeService.getAllEmployees());
        System.out.println(employeeService.getEmployeeById(emp1.getEmpId()));
    }

}
