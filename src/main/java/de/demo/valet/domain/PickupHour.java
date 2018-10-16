package de.demo.valet.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.convert.DurationUnit;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.HOURS;

@Data
@Builder
public class PickupHour {

    private int id;

    @DurationUnit(HOURS)
    private Duration hour;
}
