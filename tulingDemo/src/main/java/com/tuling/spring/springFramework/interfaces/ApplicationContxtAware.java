package com.tuling.spring.springFramework.interfaces;

import com.tuling.spring.springFramework.WdyApplicationContext;

/**
 * @Description: 类描述
 * @date: 2024/04/26 15:12
 * @author: Heavy rain
 **/
public interface ApplicationContxtAware {
    void setApplicationContext(WdyApplicationContext applicationContext);
}
