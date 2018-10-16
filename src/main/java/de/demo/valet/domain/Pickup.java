package de.demo.valet.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Pickup {

    private int id;
    private LocalDateTime time;
}
