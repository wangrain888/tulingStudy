package com.tuling.spring.user;

import com.tuling.spring.springFramework.WdyApplicationContext;

/**
 * @Description: 手写spring
 * @date: 2024/04/26 10:28
 * @author: Heavy rain
 **/
public class wdyApplication {

    public static void main(String[] args) {

        WdyApplicationContext wdyApplicationContext = new WdyApplicationContext(AppConfig.class);
//        wdyApplication.
        Object o = wdyApplicationContext.getBean("userService");

        System.out.println(o);
//        File file = new File("D:\\WORK\\智能费控Ares\\ecsServer\\tulingDemo\\target\\classes\\com\\tuling");
//        System.out.println(file.isDirectory());
    }
}
