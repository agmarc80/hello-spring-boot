package io.uslab.hellospringboot;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GreetingService {

    private final Counter counter;

    @Value("${greeting}")
    String greeting;

    public  GreetingService(MeterRegistry registry) {
        this.counter = registry.counter("received.messages");
    }

    public String getGreeting() {
        this.counter.increment();
        return greeting;
    }

}
