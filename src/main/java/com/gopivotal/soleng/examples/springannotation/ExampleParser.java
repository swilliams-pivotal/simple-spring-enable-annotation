package com.gopivotal.soleng.examples.springannotation;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;


public class ExampleParser implements ExampleRegistryAware, InitializingBean {

    private ExampleRegistry registry;

    @Override
    public void setExampleRegistry(ExampleRegistry registry) {
        Assert.isNull(this.registry, "Registry is already set!");
        this.registry = registry;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(registry, "Registry must not be null!");
        registry.register(this);
    }

    public void parse(String input) {
        //
    }

}
