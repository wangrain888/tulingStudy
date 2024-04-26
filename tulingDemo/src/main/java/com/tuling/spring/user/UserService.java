package com.tuling.spring.user;


import com.tuling.spring.springFramework.annotation.Component;
import com.tuling.spring.springFramework.interfaces.BeanNameAware;

@Component
public class UserService implements BeanNameAware {

    private String BeanName;

    @Override
    public void setBeanName(String beanName) {
        this.BeanName = beanName;
    }
}
