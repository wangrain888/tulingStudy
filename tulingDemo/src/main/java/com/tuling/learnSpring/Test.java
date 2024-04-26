package com.tuling.learnSpring;

import com.tuling.learnSpring.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

/**
 * @Description: 类描述
 * @date: 2024/04/26 17:09
 * @author: Heavy rain
 **/
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        System.out.println(context.getBean("messageSource"));
//        String message = context.getMessage("test", new Object[]{}, Locale.ENGLISH);
//        System.out.println(message);
//
//        context.publishEvent("kkkk");
//
//        String lo = context.getEnvironment().getProperty("log4j.rootLogger");
//        System.out.println(lo);

        User user = (User) context.getBean("wdy");
        System.out.println(user.getName());


    }
}
