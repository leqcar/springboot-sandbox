package com.leqcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by jongtenerife on 13/05/2016.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class RewardApplication {

    public static void main(String[] arg) {
        SpringApplication.run(RewardApplication.class, arg);
    }



}
