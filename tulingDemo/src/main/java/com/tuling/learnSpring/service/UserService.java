package com.tuling.learnSpring.service;

import com.tuling.learnSpring.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Description: 类描述
 * @date: 2024/04/26 19:57
 * @author: Heavy rain
 **/
@Service
public class UserService {

    @Value("wdy")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
