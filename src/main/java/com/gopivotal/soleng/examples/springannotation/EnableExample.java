package com.gopivotal.soleng.examples.springannotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.gopivotal.soleng.examples.springannotation.config.EnableExampleImportBeanDefinitionRegistrar;

@Documented
@Inherited
@Import({
    EnableExampleImportBeanDefinitionRegistrar.class
})
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableExample {

    Class<?> value() default SimpleExampleRegistry.class;

}
