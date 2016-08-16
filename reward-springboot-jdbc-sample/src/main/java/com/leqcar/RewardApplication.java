package com.leqcar;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

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

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create()
				.username("admin")
				.password("password")
				.build();
	}

	@Bean
	public JdbcTemplate h2PrimaryTemplate() {
		return new JdbcTemplate(primaryDataSource());
	}	
}
