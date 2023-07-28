package beanfactory;

import common.bean.BeanB;
import common.bean.PrototypeBeanA;
import common.bean.SingletonBeanA;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Objects;

public class BeanFactoryScopeDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(beanFactory);
        scanner.scan("common.bean");
        SingletonBeanA singletonBeanA1 = beanFactory.getBean(SingletonBeanA.class);
        SingletonBeanA singletonBeanA2 = beanFactory.getBean(SingletonBeanA.class);
        System.out.println(Objects.equals(singletonBeanA1, singletonBeanA2));
        PrototypeBeanA prototypeBeanA1 = beanFactory.getBean(PrototypeBeanA.class);
        PrototypeBeanA prototypeBeanA2 = beanFactory.getBean(PrototypeBeanA.class);
        System.out.println(Objects.equals(prototypeBeanA1, prototypeBeanA2));
    }
}
