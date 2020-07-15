package com.ritesh.learning.spring.controller;

import com.ritesh.learning.spring.async.LearnAsyc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.ExecutionException;

@RestController
public class MainController {

    private LearnAsyc learnAsyc;

    public MainController(LearnAsyc learnAsyc) {
        this.learnAsyc = learnAsyc;
    }

    @GetMapping("/home")
    public Mono<String> home() {
        return Mono.just("Hello World");
    }

    @GetMapping("/checkAsync")
    public String checkAsync() throws ExecutionException, InterruptedException {
        return learnAsyc.returnAsyncString().get();
    }
}
