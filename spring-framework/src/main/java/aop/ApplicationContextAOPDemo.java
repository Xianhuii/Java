package aop;

import aop.bean.BeanA;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

public class ApplicationContextAOPDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("aop");
        BeanA bean = applicationContext.getBean(BeanA.class);
        bean.fun();
    }
}
