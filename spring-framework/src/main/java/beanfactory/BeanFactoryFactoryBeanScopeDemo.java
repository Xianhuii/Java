package beanfactory;

import common.bean.BeanAFactoryBean;
import common.bean.PrototypeBeanAFactoryBean;
import common.bean.SingletonBeanAFactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Objects;

public class BeanFactoryFactoryBeanScopeDemo {
    public static void main(String[] args) throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(beanFactory);
        scanner.scan("common.bean");
        Object singletonBeanAFactoryBean1 = beanFactory.getBean("singletonBeanAFactoryBean");
        Object singletonBeanAFactoryBean2 = beanFactory.getBean("singletonBeanAFactoryBean");
        System.out.println(Objects.equals(singletonBeanAFactoryBean1, singletonBeanAFactoryBean2));
        Object prototypeBeanAFactoryBean1 = beanFactory.getBean("prototypeBeanAFactoryBean");
        Object prototypeBeanAFactoryBean2 = beanFactory.getBean("prototypeBeanAFactoryBean");
        System.out.println(Objects.equals(prototypeBeanAFactoryBean1, prototypeBeanAFactoryBean2));

        SingletonBeanAFactoryBean singletonBeanAFactory1 = beanFactory.getBean(SingletonBeanAFactoryBean.class);
        SingletonBeanAFactoryBean singletonBeanAFactory2 = beanFactory.getBean(SingletonBeanAFactoryBean.class);
        System.out.println(Objects.equals(singletonBeanAFactory1, singletonBeanAFactory2));
        PrototypeBeanAFactoryBean prototypeBeanAFactory1 = beanFactory.getBean(PrototypeBeanAFactoryBean.class);
        PrototypeBeanAFactoryBean prototypeBeanAFactory2 = beanFactory.getBean(PrototypeBeanAFactoryBean.class);
        System.out.println(Objects.equals(prototypeBeanAFactory1, prototypeBeanAFactory2));
    }
}
