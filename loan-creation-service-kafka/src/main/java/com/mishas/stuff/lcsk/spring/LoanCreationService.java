package com.mishas.stuff.lcsk.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        LcsServiceConfig.class,
        LcsConsumerConfig.class
})
public class LoanCreationService {

    public static void main(String... args) {
        SpringApplication.run(LoanCreationService.class, args);
    }
}