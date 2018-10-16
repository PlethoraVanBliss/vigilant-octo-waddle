package de.demo.valet.service;


import de.demo.valet.adapter.Adapter;

import de.demo.valet.config.*;
import de.demo.valet.domain.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import de.demo.valet.exception.*;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;

@Component
@AllArgsConstructor
public class PickupService {

    private final DummyPickupProperties pickupProperties;
    private final Adapter adapter;

    @Nonnull
    public Pickup getPickupForHour(int pickupHour) {
        Optional<PickupHour> set = ofNullable(pickupProperties.getPickups().peekFirst())
                .filter(x -> x.getHour().toHours() == pickupHour);
        AtomicReference<Pickup> pickupAtomicReference = new AtomicReference<>();
        set.ifPresent(x -> {
            pickupAtomicReference.set(adapter.adapt(x));
            pickupProperties.getPickups().removeFirst();
        });
        set.orElseThrow(() -> new NotFoundException(format("No pick up found for hour <%s>", pickupHour)));
        return pickupAtomicReference.get();
    }

}
