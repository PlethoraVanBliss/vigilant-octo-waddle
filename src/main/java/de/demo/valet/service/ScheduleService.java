package de.demo.valet.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import de.demo.valet.domain.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.validation.ClockProvider;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.time.LocalDateTime.now;

@Slf4j
@Service
@AllArgsConstructor
public class ScheduleService {

    private final ClockProvider clockProvider;
    private final PickupService pickupService;
    private final ValetService valetService;

    @Nonnull
    @Cacheable(value = "de.demo.valet.pickup", sync = true)
    public ScheduledPickup getCurrentOrNextAvailablePickup(int valetId){

        int currentHour = now(clockProvider.getClock()).getHour();
        log.info("Request available pickup for valetId <{}> and currentHour <{}>", valetId, currentHour);
        Pickup pick = pickupService.getPickupForHour(currentHour);
        Valet valet = valetService.getValet(valetId);
        return ScheduledPickup.builder()
                .id(parseInt(format("%s%s", pick.getId(), valet.getId())))
                .pickup(pick)
                .valet(valet)
                .build();
    }
}
