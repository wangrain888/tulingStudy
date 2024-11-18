package com.tuling.learnSpring;

import lombok.val;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.io.IOException;

/**
 * @Description: 类描述
 * @date: 2024/04/26 17:09
 * @author: Heavy rain
 **/
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        System.out.println(context.getBean("manService"));
        System.out.println(context.getBean("womanService"));
        System.out.println(context.getBean("womanService"));
        System.out.println(context.getBean("womanService"));
//        String message = context.getMessage("test", new Object[]{}, Locale.ENGLISH);
//        System.out.println(message);
//
//        context.publishEvent("kkkk");
//
//        String lo = context.getEnvironment().getProperty("log4j.rootLogger");
//        System.out.println(lo);

//        UserService userService = (UserService) context.getBean("userService");
//        System.out.println(userService.getUser().getName());

//        SimpleMetadataReaderFactory metadataReaderFactory = new SimpleMetadataReaderFactory();
//
//        try {
//            MetadataReader metadataReader = metadataReaderFactory.getMetadataReader("com.tuling.learnSpring.service.UserService");
//
//            ClassMetadata classMetadata = metadataReader.getClassMetadata();
//
//            AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
//
//            for (String annotationType : annotationMetadata.getAnnotationTypes()) {
//                System.out.println(annotationType);
//            }
//
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}
