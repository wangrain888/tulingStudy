package com.tuling.learnSpring.service;

import com.tuling.learnSpring.pojo.Woman;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Description: 类描述
 * @date: 2024/04/29 22:55
 * @author: Heavy rain
 **/
@Component
public class WomanService implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new Woman();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
