package com.demo.springproject.springdemo;

import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name = "Vikrant";

    public String getName() {
        return name;
    }
}
