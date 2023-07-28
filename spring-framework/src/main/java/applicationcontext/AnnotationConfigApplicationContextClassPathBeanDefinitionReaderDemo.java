package applicationcontext;

import common.bean.BeanB;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigApplicationContextClassPathBeanDefinitionReaderDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("common.bean");
        applicationContext.refresh();
        BeanB bean = applicationContext.getBean(BeanB.class);
        System.out.println(bean);
    }
}
