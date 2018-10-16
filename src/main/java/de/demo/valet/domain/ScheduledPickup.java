package de.demo.valet.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class ScheduledPickup {

    private int id;
    @NonNull
    private final Valet valet;
    @NonNull
    private final Pickup pickup;
}
