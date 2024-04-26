package com.tuling.spring.user;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService bean = configApplicationContext.getBean(UserService.class);
        System.out.println(bean);

    }



}
