package beanfactory;

import common.bean.BeanAFactoryBean;
import common.bean.PrototypeBeanA;
import common.bean.SingletonBeanA;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Objects;

public class BeanFactoryFactoryBeanDemo {
    public static void main(String[] args) throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(beanFactory);
        scanner.scan("common.bean");
        BeanAFactoryBean beanAFactoryBean = beanFactory.getBean(BeanAFactoryBean.class);
        System.out.println(beanAFactoryBean);
        System.out.println(beanAFactoryBean.getObject());
        Object bean = beanFactory.getBean("beanAFactoryBean");
        System.out.println(bean);
    }
}
