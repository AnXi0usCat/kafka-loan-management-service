package com.mishas.stuff.lcsk.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.mishas.stuff.lcsk.service"})
public class LcsServiceConfig {

    public LcsServiceConfig() {
        super();
    }
}
