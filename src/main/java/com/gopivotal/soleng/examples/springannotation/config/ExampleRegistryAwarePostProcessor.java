package com.gopivotal.soleng.examples.springannotation.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.gopivotal.soleng.examples.springannotation.ExampleRegistry;
import com.gopivotal.soleng.examples.springannotation.ExampleRegistryAware;

public class ExampleRegistryAwarePostProcessor implements BeanPostProcessor {

    private final ExampleRegistry registry;

    public ExampleRegistryAwarePostProcessor(ExampleRegistry registry) {
        this.registry = registry;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {

        if (bean instanceof ExampleRegistryAware) {
            ExampleRegistryAware aware = (ExampleRegistryAware) bean;
            aware.setExampleRegistry(registry);
            return aware;
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        return bean;
    }
}
