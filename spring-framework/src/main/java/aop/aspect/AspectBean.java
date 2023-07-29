package aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectBean {
    @Before("@annotation(aop.annotation.Aop)")
    public void before() {
        System.out.println("before");
    }
    @After("@annotation(aop.annotation.Aop)")
    public void after() {
        System.out.println("after");
    }
}
