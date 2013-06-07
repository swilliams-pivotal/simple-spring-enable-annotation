package com.gopivotal.soleng.examples.springannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableExample(CustomExampleRegistry.class)
public class CustomEnableExampleConfiguration {

    @Bean
    public ExampleParser exampleParser() {
        return new ExampleParser();
    }

}
