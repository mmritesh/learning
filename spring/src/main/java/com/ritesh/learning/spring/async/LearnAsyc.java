package com.ritesh.learning.spring.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Component
public class LearnAsyc {

    @Async
    public Future<String> returnAsyncString() {
        System.out.println("Execute method asynchronously - "
                + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            return new AsyncResult<String>("hello world !!!!");
        } catch (InterruptedException e) {
            //
        }

        return null;
    }
}
