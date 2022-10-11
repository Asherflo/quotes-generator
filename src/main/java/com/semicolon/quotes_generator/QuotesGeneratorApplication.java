package com.semicolon.quotes_generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class QuotesGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuotesGeneratorApplication.class, args);
    }

}
