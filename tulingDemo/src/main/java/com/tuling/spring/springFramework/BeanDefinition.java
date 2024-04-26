package com.tuling.spring.springFramework;

/**
 * @Description: 类描述
 * @date: 2024/04/26 14:13
 * @author: Heavy rain
 **/
public class BeanDefinition {

    private Class type;
    private String scope;
    private boolean isLazy;

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public boolean isLazy() {
        return isLazy;
    }

    public void setLazy(boolean lazy) {
        isLazy = lazy;
    }

}
