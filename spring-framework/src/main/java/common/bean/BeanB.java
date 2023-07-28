package common.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class BeanB {
    @Autowired
    private BeanA beanA;

    public BeanA getBeanA() {
        return beanA;
    }
}
