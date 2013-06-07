package com.gopivotal.soleng.examples.springannotation;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class CustomExampleRegistry implements ExampleRegistry, InitializingBean, DisposableBean {

    private final Set<ExampleParser> parsers = new HashSet<>();

    @Override
    public void register(ExampleParser exampleParser) {
        parsers.add(exampleParser);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("CustomExampleRegistry.afterPropertiesSet (load some data?)");
    }

    @Override
    public void destroy() throws Exception {
        parsers.clear();
    }

}
