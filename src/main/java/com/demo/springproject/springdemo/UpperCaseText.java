package com.demo.springproject.springdemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("upperCase")
public class UpperCaseText implements Text {

    @Override
    public String getText(String text) {
        return text.toUpperCase() ;
    }
}
