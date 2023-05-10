package com.minis.beans.factory.support;


import com.minis.beans.BeansException;
import com.minis.beans.factory.BeanFactory;
import com.minis.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    private Map<String, BeanDefinition> beanDefinitions = new ConcurrentHashMap<>(265);

    public SimpleBeanFactory() {
    }

    //getBean，容器的核心方法
    public Object getBean(String beanName) throws BeansException {
        //先尝试直接拿Bean实例
        Object singleton = this.singletons.get(beanName);
        //如果此时还没有这个Bean的实例，则获取它的定义来创建实例
        if (singleton == null) {
            //获取bean的定义
            BeanDefinition beanDefinition = beanDefinitions.get(beanName);
            if (beanDefinition == null) {
                throw new BeansException("No bean.");
            }
            try {
                singleton = Class.forName(beanDefinition.getClassName()).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            this.registerSingleton(beanName, singleton);
        }
        return singleton;
    }

    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanDefinitions.put(beanDefinition.getId(), beanDefinition);
    }

    @Override
    public Boolean containBean(String name) {
        return containsSingleton(name);
    }

    @Override
    public void registerBean(String beanName, Object obj) {
        this.registerSingleton(beanName, obj);
    }
}
