package com.mishas.stuff.misk.spring;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.mishas.stuff.misk.service"})
public class MisServiceConfig {

    public MisServiceConfig() {
        super();
    }
}
