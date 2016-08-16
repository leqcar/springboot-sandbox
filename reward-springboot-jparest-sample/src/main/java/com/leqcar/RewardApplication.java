package com.leqcar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.leqcar.repository.RewardRepository;

/**
 * Created by jongtenerife on 13/05/2016.
 */
@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class RewardApplication {

    public static void main(String[] arg) {
        SpringApplication.run(RewardApplication.class, arg);

    }

    @Bean
    public CommandLineRunner run(RewardRepository rewardRepository) {

        return arg -> {
            rewardRepository.findAll().forEach(System.out::println);
        };
    }
}
