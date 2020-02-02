package com.vikrant.springboot.login.controller;

import com.vikrant.springboot.login.model.User;
import com.vikrant.springboot.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController /*implements ErrorController*/ {

    @Autowired
    private LoginService loginService;

    //home page
    @RequestMapping("/home")
    public ModelAndView homePage() {
        return new ModelAndView("home");
    }

    //common success page
    @RequestMapping("/success")
    public ModelAndView successPage() {
        return new ModelAndView("success");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLoginPage() {
        return new ModelAndView("login", "user", new User());
    }

    @RequestMapping("/validateUser")
    public ModelAndView validateCredentials(@ModelAttribute("user") User user) {
        String viewName;
        try {
            User userFromDb = loginService.getUser(user.getUserName());
            if (!userFromDb.getPassword().isEmpty() && userFromDb.getPassword().equals(user.getPassword())) {
                viewName = "success";
            } else {
                viewName = "loginerror";
            }
        } catch (Exception e) {
            viewName = "loginerror";
        }
        return new ModelAndView(viewName);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showSignupPage() {
        return new ModelAndView("registerUser", "user", new User());
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("user") User user) throws Exception {
        String viewName;
        try {
            loginService.addUser(user);
            viewName = "success";
        } catch (Exception e) {
            viewName = "loginerror";
        }
        return new ModelAndView(viewName);
    }
}
