package com.andres.springboot.aop.sprinboot_aop.controllers;


import com.andres.springboot.aop.sprinboot_aop.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class GreetingsController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting(){

        return ResponseEntity.ok(Collections.singletonMap("greeting", greetingService.sayHello("Alex", "Hello")));

    }

    @GetMapping("/greeting-error")
    public ResponseEntity<?> greetingError(){

        return ResponseEntity.ok(Collections.singletonMap("greeting", greetingService.sayHelloError("Alex", "Hello")));

    }



}
