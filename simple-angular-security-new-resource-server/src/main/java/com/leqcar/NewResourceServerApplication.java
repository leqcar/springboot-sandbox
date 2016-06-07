package com.leqcar;

import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@ComponentScan
@RestController
public class NewResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewResourceServerApplication.class, args);
	}
	
	@RequestMapping("/")
	@CrossOrigin(origins="*", maxAge=3600) 
	// Cross Origin Resource Sharing (CORS) Negotiation, origins=* is quick and dirty, and it works, 
	// but it is not not secure and is not in any way recommended.
	public Message message() {
		return new Message("Hello Spring Boot");
	}
	
	class Message {
		private String id = UUID.randomUUID().toString();
		private String content;

		Message() {
		}

		public Message(String content) {
			this.content = content;
		}

		public String getId() {
			return id;
		}

		public String getContent() {
			return content;
		}
	}
}
