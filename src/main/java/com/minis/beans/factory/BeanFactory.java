package com.minis.beans.factory;

import com.minis.beans.BeansException;
import com.minis.beans.factory.config.BeanDefinition;

public interface BeanFactory {
    Object getBean(String beanName) throws BeansException;
    void registerBeanDefinition(BeanDefinition beanDefinition);
    Boolean containBean(String name);
    void registerBean(String name, Object obj);
}
