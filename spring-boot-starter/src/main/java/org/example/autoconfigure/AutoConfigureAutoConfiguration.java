package org.example.autoconfigure;

import org.example.runner.AutoConfigureRunner;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

//@AutoConfiguration
public class AutoConfigureAutoConfiguration {
    @Bean
    public ApplicationRunner autoConfigureRunner() {
        return new AutoConfigureRunner();
    }
}
