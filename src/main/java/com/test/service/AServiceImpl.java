package com.test.service;

public class AServiceImpl implements AService {

    private String property1;

    private String property2;

    private String name;

    private int level;

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    @Override
    public void sayHello() {
        System.out.println("AServiceImpl say Hello!");
    }
}
