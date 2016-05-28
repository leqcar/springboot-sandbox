package com.leqcar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by JONGT on 5/29/2016.
 */
@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class JsonReaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsonReaderApplication.class, args);
    }

    @Bean
    public CommandLineRunner runJsonWithObjectMapper() {
        return args -> {
            ObjectMapperDemo obj = new ObjectMapperDemo();
            obj.readJsonWithObjectMapper();
        };
    }

    @Bean
    public CommandLineRunner runJsonWithObjectMapperToMap() {
        return args -> {
            ObjectMapperToMapDemo obj = new ObjectMapperToMapDemo();
            obj.readJsonWithObjectMapper();
        };
    }
}
