package com.demo.springproject.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @Autowired
    private Person person;

    @Autowired
    @Qualifier("lowerCase")
    private Text lowerCaseText;

    @Autowired
    @Qualifier("upperCase")
    private Text upperCaseText;


    @RequestMapping("/")
    public String index() {
        return "Hello World!";
    }

    @RequestMapping("/getName")
    public String getName() {
        return person.getName();
    }

    @RequestMapping("/lowerCaseText")
    public String writeLowerCaseText() {
        return lowerCaseText.getText("Hello World!");
    }

    @RequestMapping("/upperCaseText")
    public String writeUpperCaseText() {
        return upperCaseText.getText("Hello World!");
    }
}