package com.minis.context;

import com.minis.beans.BeansException;
import com.minis.beans.factory.BeanFactory;
import com.minis.beans.factory.config.BeanDefinition;
import com.minis.beans.factory.support.SimpleBeanFactory;
import com.minis.beans.factory.xml.XmlBeanDefinitionReader;
import com.minis.core.ClassPathXmlResource;
import com.minis.core.Resource;


public class ClassPathXmlApplicationContext implements BeanFactory {
    BeanFactory beanFactory;

    //context负责整合容器的启动过程，读外部配置，解析Bean定义，创建BeanFactory
    public ClassPathXmlApplicationContext(String fileName) {
        Resource resource = new ClassPathXmlResource(fileName);
        SimpleBeanFactory beanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);
        this.beanFactory = beanFactory;
    }

    //context再对外提供一个getBean，底下就是调用的BeanFactory对应的方法
    public Object getBean(String beanName) throws BeansException {
        return this.beanFactory.getBean(beanName);
    }

    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanFactory.registerBeanDefinition(beanDefinition);
    }

    @Override
    public Boolean containBean(String name) {
        return this.beanFactory.containBean(name);
    }

    @Override
    public void registerBean(String name, Object obj) {
        this.beanFactory.registerBean(name, obj);
    }
}
