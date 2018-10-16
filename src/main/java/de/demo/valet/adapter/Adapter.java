package de.demo.valet.adapter;

import de.demo.valet.domain.Pickup;
import de.demo.valet.domain.PickupHour;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import javax.validation.ClockProvider;
import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class Adapter {
    private final ClockProvider clockProvider;

    @Nonnull
    public Pickup adapt(@Nonnull PickupHour pickupHour) {
        return Pickup.builder()
                .id(pickupHour.getId())
                .time(LocalDateTime.now(clockProvider.getClock()).withHour((int) pickupHour.getHour().toHours()))
                .build();
    }
}