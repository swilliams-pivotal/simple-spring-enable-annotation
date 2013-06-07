package com.gopivotal.soleng.examples.springannotation;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class SimpleExampleRegistry implements ExampleRegistry, InitializingBean, DisposableBean {

    private final Set<ExampleParser> parsers = new HashSet<>();

    public void register(ExampleParser exampleParser) {
        parsers.add(exampleParser);
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("SimpleExampleRegistry.afterPropertiesSet (load some data?)");
    }

    public void destroy() throws Exception {
        parsers.clear();
    }

}
