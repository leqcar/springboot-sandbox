package com.leqcar.hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by jongtenerife on 30/05/2016.
 */
@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage helloMessage) throws InterruptedException {
        //simulated delay
        Thread.sleep(3000);
        return new Greeting("Hello " + helloMessage.getName() + "!");
    }
}
