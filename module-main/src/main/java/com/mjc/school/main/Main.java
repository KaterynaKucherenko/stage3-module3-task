package com.mjc.school.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        Menu menu = applicationContext.getBean(Menu.class);
        menu.start();
    }
}