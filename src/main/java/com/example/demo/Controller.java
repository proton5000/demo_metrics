package com.example.demo;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private static Integer myIntCounter = 0;

    @Autowired
    MeterRegistry registry;

    @GetMapping("/test")
    public Integer getInt() {

        myIntCounter++;

        // counter to count different types of messages received
        registry.counter("custom.metrics.message", "value", myIntCounter.toString()).increment();

        return myIntCounter;
    }
}
