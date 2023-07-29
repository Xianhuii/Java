package aop.bean;

import aop.annotation.Aop;
import org.springframework.stereotype.Component;

@Component
public class BeanA {
    @Aop
    public void fun() {
        System.out.println("fun");
    }
}
