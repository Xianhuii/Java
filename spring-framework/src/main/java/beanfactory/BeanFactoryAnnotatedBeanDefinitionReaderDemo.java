package beanfactory;

import common.bean.BeanA;
import common.bean.BeanB;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

public class BeanFactoryAnnotatedBeanDefinitionReaderDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(beanFactory);
        reader.register(BeanA.class, BeanB.class);
        BeanB beanB = beanFactory.getBean(BeanB.class);
        System.out.println(beanB.getBeanA());
    }
}
