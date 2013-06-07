package com.gopivotal.soleng.examples.springannotation.config;

import java.util.Map;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;


public class EnableExampleImportBeanDefinitionRegistrar implements
        ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(
            AnnotationMetadata importingClassMetadata,
            BeanDefinitionRegistry registry) {

        Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes("com.gopivotal.soleng.examples.springannotation.EnableExample");
        Class<?> registryImpl = (Class<?>) attributes.get("value");

        BeanDefinitionBuilder registryBuilder = BeanDefinitionBuilder.genericBeanDefinition(registryImpl);
        String registryBeanName = BeanDefinitionReaderUtils.registerWithGeneratedName(registryBuilder.getBeanDefinition(), registry);

        BeanDefinitionBuilder registryPostProcessorBuilder = BeanDefinitionBuilder.genericBeanDefinition(ExampleRegistryAwarePostProcessor.class);
        registryPostProcessorBuilder.addConstructorArgReference(registryBeanName);
        BeanDefinitionReaderUtils.registerWithGeneratedName(registryPostProcessorBuilder.getBeanDefinition(), registry);

    }

}
