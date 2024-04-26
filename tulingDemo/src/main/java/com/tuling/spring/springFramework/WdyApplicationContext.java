package com.tuling.spring.springFramework;

import com.tuling.spring.exception.SpringInitException;
import com.tuling.spring.springFramework.annotation.*;
import com.tuling.spring.springFramework.interfaces.ApplicationContxtAware;
import com.tuling.spring.springFramework.interfaces.BeanNameAware;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.Introspector;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 类描述
 * @date: 2024/04/26 10:28
 * @author: Heavy rain
 **/
public class WdyApplicationContext {

    //单例
    private static String SINGLETON = "singleton";

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
    //单例bean集合
    private Map<String, Object> singletonBeanMap = new HashMap<>();

    private Class configClass;

    public WdyApplicationContext(Class classes) {
        this.configClass = classes;

        //扫描
        try {
            this.doScan(classes);
        } catch (SpringInitException e) {
            logger.error(e.getMessage(), e);
        }

        //创建bean
        for (String beanName : beanDefinitionMap.keySet()) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            //不是懒加载、是单例模式
            if (!beanDefinition.isLazy() && beanDefinition.getScope().equals(SINGLETON)) {
                Object bean = createBean(beanName, beanDefinition);
                singletonBeanMap.put(beanName, bean);
            }
        }

    }

    /**
     * 创建bean
     *
     * @param beanName
     * @param beanDefinition
     * @return
     */
    private Object createBean(String beanName, BeanDefinition beanDefinition) {

        Class clazz = beanDefinition.getType();

        try {
            Object o = clazz.newInstance();

            for (Field declaredField : clazz.getDeclaredFields()) {
                if (declaredField.isAnnotationPresent(Autowried.class)) {
                    Object bean = getBean(declaredField.getName());
                    declaredField.setAccessible(true);
                    declaredField.set(o, bean);
                }
            }

            if (o instanceof BeanNameAware) {
                ((BeanNameAware) o).setBeanName(beanName);
            }

            if (o instanceof ApplicationContxtAware) {
                ((ApplicationContxtAware) o).setApplicationContext(this);
            }
            return o;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;

    }

    /**
     * 获取bean
     *
     * @param beanName
     * @return
     */
    public Object getBean(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);

        if (beanDefinition == null) {
            throw new NullPointerException();
        }

        if (SINGLETON.equals(beanDefinition.getScope())) {
            Object result = singletonBeanMap.get(beanName);
            if (result == null) {
                result = createBean(beanName, beanDefinition);
                singletonBeanMap.put(beanName, result);
            }
            return result;
        } else {
            return createBean(beanName, beanDefinition);
        }


    }

    private void doScan(Class classes) throws SpringInitException {
        boolean annotationPresent = classes.isAnnotationPresent(ConponentScan.class);
        if (annotationPresent) {
            ConponentScan conponentScan = (ConponentScan) classes.getAnnotation(ConponentScan.class);
            String path = conponentScan.value();

//            path = path.replaceAll("\\.", "/");

            ClassLoader classLoader = this.getClass().getClassLoader();

//            URL resource = classLoader.getResource(path);

            File file = new File("D:\\WORK\\智能费控Ares\\ecsServer\\tulingDemo\\target\\classes\\com\\tuling\\spring");

            List<File> listFiles = new ArrayList<>();

            getListClassFile(file, listFiles);

            for (File listFile : listFiles) {
                String absolutePath = listFile.getAbsolutePath();

                //从com开始，去除.class
                String className = absolutePath.substring(absolutePath.indexOf("com"), absolutePath.indexOf(".class"))
                        .replace("\\", ".");

                try {
                    Class<?> clazz = classLoader.loadClass(className);
                    if (clazz.isAnnotationPresent(Component.class)) {
                        BeanDefinition beanDefinition = new BeanDefinition();
                        beanDefinition.setType(clazz);
                        beanDefinition.setLazy(clazz.isAnnotationPresent(Lazy.class));
                        if (clazz.isAnnotationPresent(Scope.class)) {
                            Scope scope = clazz.getAnnotation(Scope.class);
                            beanDefinition.setScope(scope.value());
                        } else {
                            beanDefinition.setScope(SINGLETON);
                        }

                        String beanName = clazz.getAnnotation(Component.class).value();
                        if (StringUtils.isEmpty(beanName)) {
                            beanName = Introspector.decapitalize(clazz.getSimpleName());
                        }
                        beanDefinitionMap.put(beanName, beanDefinition);
                    }

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        } else {
            throw new SpringInitException("缺少spring配置类");
        }


    }

    /**
     * 递归获取所有class文件
     *
     * @param file
     * @param listFiles
     * @return
     */
    private List<File> getListClassFile(File file, List<File> listFiles) {

        if (file.isDirectory()) {
            for (File listFile : file.listFiles()) {

                if (listFile.isDirectory())
                    getListClassFile(listFile, listFiles);
                else
                    listFiles.add(listFile);
            }
        }

        if (file.isFile()) {
            listFiles.add(file);
        }

        return listFiles;
    }

}
