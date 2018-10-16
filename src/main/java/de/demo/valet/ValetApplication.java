package de.demo.valet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ClockProvider;
import java.time.Clock;

@RestController
@EnableCaching
@SpringBootApplication
public class ValetApplication {

  @Bean
  ClockProvider clockProvider(){
    return Clock::systemDefaultZone;
  }

  public static void main(String[] args) {
    SpringApplication.run(ValetApplication.class, args);
  }
}
