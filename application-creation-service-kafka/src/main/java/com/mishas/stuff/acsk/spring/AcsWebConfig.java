package com.mishas.stuff.acsk.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.mishas.stuff.acsk.web"})
public class AcsWebConfig {

    public AcsWebConfig() {
        super();
    }
}
