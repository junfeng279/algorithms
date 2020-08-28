package com.summer.algorithms.base.ioc;

public class TestDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        ApplicationContext applicationContext = new AnnotationApplicationContext();
        System.out.println(applicationContext.getBean("user"));;
    }
}
