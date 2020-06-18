package com.ritesh.learning.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MainController {

    @GetMapping("/home")
    public Mono<String> home() {
        return Mono.just("Hello World");
    }
}
