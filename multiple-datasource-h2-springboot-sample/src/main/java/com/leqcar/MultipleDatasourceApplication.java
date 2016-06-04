package com.leqcar;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@ComponentScan
@EnableConfigurationProperties
public class MultipleDatasourceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MultipleDatasourceApplication.class, args);
	}

}
