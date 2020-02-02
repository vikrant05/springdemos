package com.vikrant.springboot.login.controller;

import com.vikrant.springboot.login.model.Employee;
import com.vikrant.springboot.login.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController /*implements ErrorController*/ {

    @Autowired
    EmployeeService employeeService;

    //the welcome page
    @RequestMapping("/welcome")
    public ModelAndView firstPage() {
        return new ModelAndView("welcome");
    }

    @RequestMapping("/error1")
    public ModelAndView errorPage() {
        return new ModelAndView("error1");
    }

    //show the add employee form and also pass an empty backing bean object to store the form field values
    @RequestMapping(value = "/addNewEmployee", method = RequestMethod.GET)
    public ModelAndView show() {
        return new ModelAndView("addEmployee", "emp", new Employee());
    }

    //Get the form field values which are populated using the backing bean and store it in db
    @RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST)
    public ModelAndView processRequest(@ModelAttribute("emp") Employee emp) throws Exception{
        ModelAndView model;
        try {
            employeeService.insertEmployee(emp);
        }
        catch(Exception e) {
           model = new ModelAndView("error1");
            return model;
            //throw e;
        }
        List<Employee> employees = employeeService.getAllEmployees();
        model = new ModelAndView("getEmployees");
        model.addObject("employees", employees);
        return model;
    }

    //show all employees saved in db
    @RequestMapping("/getEmployees")
    public ModelAndView getEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        ModelAndView model = new ModelAndView("getEmployees");
        model.addObject("employees", employees);
        return model;
    }

   /* @Override
    public String getErrorPath() {
        return "/error";
    }*/
}
