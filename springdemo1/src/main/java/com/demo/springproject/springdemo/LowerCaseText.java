package com.demo.springproject.springdemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("lowerCase")
public class LowerCaseText implements Text{
    @Override
    public String getText(String text) {
        return text.toLowerCase();
    }
}
