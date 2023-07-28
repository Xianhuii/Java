package common.bean;

import org.springframework.stereotype.Component;

@Component
public class BeanPostprocessorBeanA {
    private long timestamp;

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
