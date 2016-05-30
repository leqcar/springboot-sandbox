package com.leqcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Reference :
 * https://spring.io/blog/2015/01/12/spring-and-angular-js-a-secure-single-page-application
 */

@SpringBootApplication
public class SimpleAngularSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleAngularSecurityApplication.class, args);
    }
}
