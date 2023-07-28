package beanfactory;

import common.bean.BeanPostprocessorBeanA;
import common.beanpostprocessor.BeanPostprocessorBeanABeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

public class BeanFactoryBeanPostProcessorDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.addBeanPostProcessor(new BeanPostprocessorBeanABeanPostProcessor());
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(beanFactory);
        scanner.scan("common.bean");
        BeanPostprocessorBeanA beanA = beanFactory.getBean(BeanPostprocessorBeanA.class);
        System.out.println(beanA.getTimestamp());
    }
}
