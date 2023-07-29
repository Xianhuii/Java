package org.example.factories;

import org.example.runner.FactoriesRunner;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

public class FactoriesAutoConfiguration {
    @Bean
    public ApplicationRunner factoriesRunner() {
        return new FactoriesRunner();
    }
}
