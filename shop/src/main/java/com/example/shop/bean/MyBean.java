package com.example.shop.bean;

import org.springframework.stereotype.Component;

@Component
public class MyBean {

    private final String name;

    public MyBean() {
        this.name = "MyBean";
    }

    public String getName() {
        return name;
    }

    public String hello() {
        return "Hello from " + name + "!";
    }
}
