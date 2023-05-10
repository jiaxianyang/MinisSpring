package com.test;


import com.minis.beans.BeansException;
import com.minis.context.ClassPathXmlApplicationContext;
import com.test.service.AService;

public class Test1 {
    public static void main(String[] args) throws BeansException {
        ClassPathXmlApplicationContext ctx = new
                ClassPathXmlApplicationContext("beans.xml");
        AService aService = (AService)ctx.getBean("aservice");
        aService.sayHello();
    }
}
