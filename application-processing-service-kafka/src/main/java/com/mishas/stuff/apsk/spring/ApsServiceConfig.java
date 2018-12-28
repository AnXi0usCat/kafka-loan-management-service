package com.mishas.stuff.apsk.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.mishas.stuff.apsk.service"})
public class ApsServiceConfig {
    public ApsServiceConfig() {
        super();
    }
}
