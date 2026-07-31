package com.example.actuatordemo;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        // Simulate checking an external downstream service API
        boolean serviceUp = ThreadLocalRandom.current().nextBoolean(); 
        
        if (serviceUp) {
            return Health.up()
                    .withDetail("External Service", "Available and responding fast")
                    .withDetail("Response Time", "45ms")
                    .build();
        }
        
        return Health.down()
                .withDetail("External Service", "Unreachable / Timeout")
                .withDetail("Error Code", 503)
                .build();
    }
}
