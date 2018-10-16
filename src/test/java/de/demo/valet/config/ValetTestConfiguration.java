package de.demo.valet.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.validation.ClockProvider;

import static de.demo.valet.util.StubUtils.getClock;
import static java.time.LocalDateTime.now;

@org.springframework.boot.test.context.TestConfiguration
public class ValetTestConfiguration {

    @Bean
    public ClockProvider clockProvider(@Value("${de.demo.vallet.test.pick-up-hour:6}") int hour){
        return () -> getClock(now().withHour(hour));
    }
}