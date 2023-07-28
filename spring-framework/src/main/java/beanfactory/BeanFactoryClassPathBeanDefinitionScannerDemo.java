package beanfactory;

import common.bean.BeanB;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

public class BeanFactoryClassPathBeanDefinitionScannerDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(beanFactory);
        scanner.scan("common.bean");
        BeanB beanB = beanFactory.getBean(BeanB.class);
        System.out.println(beanB.getBeanA());
    }
}
