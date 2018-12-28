package com.mishas.stuff.misk.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        MisServiceConfig.class,
        MisConsumerConfig.class
})
public class MoneyIssuingService {

    public static void main (String... args) {
        SpringApplication.run(MoneyIssuingService.class, args);
    }
}
