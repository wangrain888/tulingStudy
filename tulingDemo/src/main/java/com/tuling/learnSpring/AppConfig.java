package com.tuling.learnSpring;

import com.tuling.learnSpring.pojo.User;
import com.tuling.learnSpring.propertyEditor.StringToUserEditor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 类描述
 * @date: 2024/04/26 17:19
 * @author: Heavy rain
 **/
@Configurable
@ComponentScan("com.tuling.learnSpring")
@PropertySource("classpath:log4j.properties")
public class AppConfig {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("message");
        source.setDefaultEncoding("UTF-8");
        return source;
    }

    @Bean
    public ApplicationListener applicationListener() {
        return new ApplicationListener() {
            @Override
            public void onApplicationEvent(ApplicationEvent applicationEvent) {
                System.out.println("接收到一个时间发布");
            }
        };
    }

    @Bean
    public CustomEditorConfigurer customAutowireConfigurer() {
        CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
        Map<Class<?>, Class<? extends PropertyEditor>> propertyEditorMap = new HashMap<>();
        propertyEditorMap.put(User.class, StringToUserEditor.class);
        customEditorConfigurer.setCustomEditors(propertyEditorMap);
        return customEditorConfigurer;
    }


}
