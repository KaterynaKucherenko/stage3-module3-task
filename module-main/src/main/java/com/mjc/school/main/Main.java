package com.mjc.school.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


import java.lang.reflect.InvocationTargetException;
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableJpaAuditing
public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        ApplicationContext applicationContext = SpringApplication.run(Main.class, args);
        Menu menu = applicationContext.getBean(Menu.class);
        menu.start();
    }
}