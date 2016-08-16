package com.leqcar;

import javax.sql.DataSource;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class WebConfiguration {
	@Value("${spring.secondDatasource.schema}")
	private String schema;
	
	@Value("${spring.secondDatasource.data}")
	private String data;
	
	@Value("${secondDataSource.db.name}")
	private String name;
	
    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean 
        = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
    
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create()
				.username("admin")
				.password("password")
				.build();
	}
	
	
	@Bean
	@ConfigurationProperties(prefix = "spring.secondDatasource")
	public DataSource secondaryDataSource() {
		return new EmbeddedDatabaseBuilder()
			.setType(EmbeddedDatabaseType.H2)
			.setName(name)
			.addScripts(schema, data)
			.build();
	}
	
	@Bean
	public JdbcTemplate h2PrimaryTemplate() {
		return new JdbcTemplate(primaryDataSource());
	}
	
	@Bean
	public JdbcTemplate h2SecondaryTemplate() {
		return new JdbcTemplate(secondaryDataSource());
	}
}
