package com.leqcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

/**
 * Created by jongtenerife on 30/05/2016.
 *
 * Reference :https://spring.io/guides/gs/messaging-stomp-websocket/
 *
 */
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableWebSocketMessageBroker
public class WebSocketStompApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSocketStompApplication.class, args);
    }
}
