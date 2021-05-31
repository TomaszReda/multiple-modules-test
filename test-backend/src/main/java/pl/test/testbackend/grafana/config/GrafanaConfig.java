package pl.test.testbackend.grafana.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GrafanaConfig {

    @Bean
    MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
        return registry -> registry.config().commonTags("application", "TESTAPP");
    }

    @Bean
    Counter testCounter(MeterRegistry meterRegistry) {
        return meterRegistry.counter("test_counter_app");
    }

    @Bean
    Timer testTimer(MeterRegistry meterRegistry) {
        return meterRegistry.timer("test_timer_app");
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
