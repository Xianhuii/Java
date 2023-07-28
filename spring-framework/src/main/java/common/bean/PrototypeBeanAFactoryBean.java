package common.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBeanAFactoryBean implements FactoryBean<BeanA> {
    @Override
    public BeanA getObject() throws Exception {
        return new BeanA();
    }

    @Override
    public Class<?> getObjectType() {
        return BeanA.class;
    }
}
