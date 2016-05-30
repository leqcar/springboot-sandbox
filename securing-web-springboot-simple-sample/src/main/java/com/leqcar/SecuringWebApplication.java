package com.leqcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * Created by jongtenerife on 30/05/2016.
 */
@SpringBootApplication
@ComponentScan
@Configuration
@EnableAutoConfiguration
@EnableWebSecurity
public class SecuringWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecuringWebApplication.class, args);
    }
}
