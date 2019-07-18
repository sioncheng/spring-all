package com.github.sioncheng.coffeeshop;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AAConfiguration {

    public AAConfiguration() {}

    public AAConfiguration(String s) {

    }

    @Bean
    public AA aa() {
        return new AA();
    }
}
