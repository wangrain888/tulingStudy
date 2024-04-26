package com.tuling.learnSpring.pojo;

import org.springframework.stereotype.Service;

/**
 * @Description: 类描述
 * @date: 2024/04/26 19:57
 * @author: Heavy rain
 **/

@Service
public class User {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
