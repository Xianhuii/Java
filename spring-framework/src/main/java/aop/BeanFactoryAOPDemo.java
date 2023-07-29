package aop;

import aop.bean.BeanA;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

/**
 * 默认不支持AOP，需要自己手动编写业务逻辑
 */
public class BeanFactoryAOPDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(beanFactory);
        scanner.scan("aop");
        BeanA bean = beanFactory.getBean(BeanA.class);
        bean.fun();
    }
}
