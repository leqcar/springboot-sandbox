package com.leqcar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by JONGT on 5/31/2016.
 */
@RestController
public class SimpleController {
    @RequestMapping("/resource")
    public Map<String, Object> home() {
        Map<String, Object> model = new HashMap<>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello Angular");
        return model;
    }

    @RequestMapping("/user")  // to service the 'authenticate()' function
    public Principal user(Principal user) {
        return user;
    }
}
