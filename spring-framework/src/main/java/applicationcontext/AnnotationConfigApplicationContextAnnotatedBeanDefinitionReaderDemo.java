package applicationcontext;

import common.bean.BeanA;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigApplicationContextAnnotatedBeanDefinitionReaderDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanA.class);
        applicationContext.refresh();
        BeanA bean = applicationContext.getBean(BeanA.class);
        System.out.println(bean);
    }
}
