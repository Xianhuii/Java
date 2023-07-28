package common.beanpostprocessor;

import common.bean.BeanA;
import common.bean.BeanPostprocessorBeanA;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.function.Consumer;

public class BeanPostprocessorBeanABeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        process(bean, b -> {
            System.out.println("BeanABeanPostProcessor postProcessBeforeInitialization start ==================");
            BeanPostprocessorBeanA beanA = (BeanPostprocessorBeanA) b;
            System.out.println(beanA.getTimestamp());
            beanA.setTimestamp(System.currentTimeMillis());
            System.out.println("BeanABeanPostProcessor postProcessBeforeInitialization end ==================");
        });
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        process(bean, b -> {
            System.out.println("BeanABeanPostProcessor postProcessAfterInitialization start ==================");
            BeanPostprocessorBeanA beanA = (BeanPostprocessorBeanA) b;
            System.out.println(beanA.getTimestamp());
            beanA.setTimestamp(System.currentTimeMillis());
            System.out.println("BeanABeanPostProcessor postProcessAfterInitialization end ==================");
        });
        return bean;
    }

    private void process(Object bean, Consumer<Object> consumer) {
        if (bean instanceof BeanPostprocessorBeanA) {
            consumer.accept(bean);
        }
    }
}
